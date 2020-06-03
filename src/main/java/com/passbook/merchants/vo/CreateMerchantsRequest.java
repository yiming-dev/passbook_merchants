package com.passbook.merchants.vo;


import com.passbook.merchants.constants.ErrorCode;
import com.passbook.merchants.dao.MerchantsDao;
import com.passbook.merchants.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>创建商户请求对象</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {
    /**商户名称*/
    private String name;
    /**商户 logo*/
    private String logoUrl;
    /**商户执照*/
    private String businessLicenceUrl;
    /**商户电话*/
    private String phone;
    /**商户地址*/
    private String address;

    /**
     * <h2>验证请求有效性</h2>
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if(merchantsDao.findByName(this.name) != null){
            return ErrorCode.DUPLICATE_NAME;
        }
        if(null == this.name){
            return ErrorCode.EMPTY_NAME;
        }
        if(null == this.logoUrl){
            return ErrorCode.EMPTY_LOGO;
        }
        if(null == this.businessLicenceUrl){
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if(null == this.address){
            return ErrorCode.EMPTY_ADDRESS;
        }
        if(null == this.phone){
            return ErrorCode.ERROR_PHONE;
        }
        return ErrorCode.SUCCESS;
    }

    /**
     * Transfer request object to merchant object
     * @return
     */
    public Merchants toMerchants(){
        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicensesUrl(businessLicenceUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        return merchants;
    }
}
