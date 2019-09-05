package com.zhuofengyuan.mlszm.vote.admin.exception;

import com.zhuofengyuan.mlszm.vote.exception.FengtoosException;
import com.zhuofengyuan.mlszm.vote.resp.RestResponseBo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FengtoosException.class)
    public @ResponseBody
    RestResponseBo normalException(FengtoosException e){
        return RestResponseBo.fail(e.getCode(), e.getMessage());
    }

}
