package com.passbook.merchants.service;

import com.alibaba.fastjson.JSON;
import com.passbook.merchants.service.impl.MerchantsServImpl;
import com.passbook.merchants.vo.CreateMerchantsRequest;
import com.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <h1>商户服务测试类</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServTest {
    public MerchantsServTest() {
    }

    @Autowired
    private MerchantsServImpl merchantsServImpl;

    @Test
    //@Transactional
    public void testCreateMerchantsServ(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("facebook");
        request.setLogoUrl("www.kfc.com");
        request.setBusinessLicenceUrl("www.kfc.com");
        request.setPhone("5141111111");
        request.setAddress("Complex Angrignon");
        System.out.println(JSON.toJSONString(merchantsServImpl.createMerchants(request)));
    }

    @Test
    public void testBuildMerchantsInfoById(){
        System.out.println(JSON.toJSONString(merchantsServImpl.buildMerchantsInfoById(2)));
    }
    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(3);
        passTemplate.setTitle("title: subway-2");
        passTemplate.setSummary("summary: subway");
        passTemplate.setDesc("sandwich");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(true);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(),-10));
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));
        System.out.println(JSON.toJSONString(merchantsServImpl.dropPassTemplate(passTemplate)));
    }
}
