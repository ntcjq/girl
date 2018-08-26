package com.example.girl.handle;

import com.example.girl.entity.Result;
import com.example.girl.exception.GirlException;
import com.example.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtil.faild(girlException.getCode(),girlException.getMessage());
        }
        logger.error("【系统异常】{}",e.getMessage());
        return ResultUtil.faild(500,e.getMessage());
    }
}