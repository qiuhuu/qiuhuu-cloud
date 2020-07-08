package com.qiuhuu.common.core.exception;

import com.qiuhuu.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author : qiuhuu
 * @date : 2020-07-08 11-06
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 捕获自定义异常
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler({CloudException.class})
    public static ResultBody exception(CloudException ex, HttpServletRequest request, HttpServletResponse response) {
        //todo 后续改进
        ResultBody resultBody = new ResultBody().failure(400,ex.getMessage());
        response.setStatus(resultBody.getHttpStatus());
        log.error("捕获到自定义异常：{}，msg:{}",ex.getStackTrace()[0].getClassName(),ex.getMessage());
        return resultBody;
    }

    /**
     * 捕获其他异常
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    public static ResultBody exception(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        //todo 后续改进
        ResultBody resultBody = new ResultBody().failure(400,ex.getMessage());
        response.setStatus(resultBody.getHttpStatus());
        log.error(ex.getMessage());
        return resultBody;
    }
}
