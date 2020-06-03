package com.passbook.merchants.controller;


import com.alibaba.fastjson.JSON;
import com.passbook.merchants.service.IMerchantsServ;
import com.passbook.merchants.service.impl.MerchantsServImpl;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <h1>商户服务controller</h1>
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    private final MerchantsServImpl merchantsServImpl;

    @Autowired
    public MerchantsController(MerchantsServImpl merchantsServImpl) {
        this.merchantsServImpl = merchantsServImpl;
    }

    @ResponseBody
    @RequestMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants:{}", JSON.toJSONString(request));
        return merchantsServImpl.createMerchants(request);
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo:{}",id);
        return merchantsServImpl.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @RequestMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("dropPassTemplate:{}",passTemplate);
        return merchantsServImpl.dropPassTemplate(passTemplate);
    }
}
