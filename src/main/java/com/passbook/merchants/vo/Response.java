package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private Integer errorCode;
    private String errorMsg = "";
    /**
     * returned object
     */
    private Object data;

    /**
     * return object function
     */
    private Response(Object data){
        this.data = data;
    }
}
