package com.passbook.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.passbook.merchants.constants.Constants;
import com.passbook.merchants.constants.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import com.passbook.merchants.entity.Merchants;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.CreateMerchantsResponse;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <h1>商户服务接口实现</h1>
 */
@Slf4j
@Service
@Repository
public class MerchantsServImpl implements IMerchantsServ{
    /**Merchants 数据库接口*/
    private final MerchantsDao merchantsDao;
    /**kafka 客户端*/
    private final KafkaTemplate<String,String> kafkaTemplate;
    @Autowired
    public MerchantsServImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode errorCode = request.validate(merchantsDao);
        if(errorCode != ErrorCode.SUCCESS){
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }
        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);
        if(null == merchants){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {
        Response response = new Response();
        ErrorCode errorCode = template.validate(merchantsDao);
        if(errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else {
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLETE_TOPIC,
                    Constants.TEMPLETE_TOPIC,
                    passTemplate
            );
            log.info("DropPassTemplate:{}",passTemplate);
        }
        return response;
    }
}
