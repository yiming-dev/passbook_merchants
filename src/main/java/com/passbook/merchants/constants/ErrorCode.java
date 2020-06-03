package com.passbook.merchants.constants;

/**
 * <h2>错误码枚举定义</h2>
 */
public enum ErrorCode {
    SUCCESS(0,""),
    DUPLICATE_NAME(1,"DUPLICATE_NAME"),
    EMPTY_NAME(1,"EMPTY_NAME"),
    EMPTY_LOGO(2,"EMPTY_LOGO"),
    EMPTY_BUSINESS_LICENSE(3,"EMPTY_BUSINESS_LICENSE"),
    EMPTY_ADDRESS(4,"EMPTY_ADDRESS"),
    MERCHANTS_NOT_EXIST(5,"MERCHANTS_NOT_EXIST"),
    ERROR_PHONE(6,"ERROR_PHONE");

    private Integer code;
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
