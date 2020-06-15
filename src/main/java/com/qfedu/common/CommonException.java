package com.qfedu.common;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

public class CommonException {
    //针对于哪个异常处理的异常处理器
    @ExceptionHandler(ConstraintViolationException.class)

    public JsonResult constraintViolationException(ConstraintViolationException ex) {
        //验证不通过的信息
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println(message);
        }
        return new JsonResult(0, message);

    }
}
