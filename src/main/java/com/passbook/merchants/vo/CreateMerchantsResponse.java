package com.passbook.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create merchants response object
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMerchantsResponse {
    /** if fail return -1*/
    private Integer id;
}
