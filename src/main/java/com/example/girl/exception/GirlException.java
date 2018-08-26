package com.example.girl.exception;


import com.example.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {

    private Integer code = 500;

    public GirlException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public GirlException(String msg){
        super(msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
