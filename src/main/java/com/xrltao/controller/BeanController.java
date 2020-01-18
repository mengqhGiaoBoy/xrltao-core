package com.xrltao.controller;

import com.xrltao.domain.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mengqh
 * @version 1.0
 * @date 2020/1/18 19:00
 * @Description
 */
@ControllerAdvice
public class BeanController {
    private Logger logger =  LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO getException(Exception e){
        logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(e);
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setStatus(404);
        return resultDTO;
    }
}
