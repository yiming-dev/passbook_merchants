package com.passbook.merchants.dao;

import com.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Merchants Dao 接口
 */
@Repository
public interface MerchantsDao extends JpaRepository<Merchants,Integer>{
    /**
     * 根据id获取商户对象
     * @Param id 商户id
     * @Return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据商户名称获取商户对象
     * @Param name 商户名称
     * @Return {@link Merchants}
     */
    Merchants findByName(String name);
}
