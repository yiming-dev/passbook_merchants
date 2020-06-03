package com.passbook.merchants.service;

import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import com.passbook.merchants.vo.Response;
import org.springframework.stereotype.Repository;

/**
 * <h1>对商户服务接口定义</h1>
 */
@Repository
public interface IMerchantsServ {

    /**
     * <h2>创建商户服务</h2>
     * @param request {@link CreateMerchantsRequest}创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * <h2>根据商户id构造商户信息</h2>
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     * @param template {@link PassTemplate}
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);
}
