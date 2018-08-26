package com.example.girl.enums;

public enum ResultEnum {

    UNKNOW_EXCEPTION(-1,"未知错误"),
    DATABASE_EXCEPTION(2,"数据库操作异常");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
