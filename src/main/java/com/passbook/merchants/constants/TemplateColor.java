package com.passbook.merchants.constants;

public enum TemplateColor {

    RED(1,"RED"),
    GREEN(1,"GREEN"),
    BLUE(1,"BLUE"),;
    /** color code */
    private Integer code;
    /** color desc */
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }
}
