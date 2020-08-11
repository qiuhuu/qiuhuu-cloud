package com.qiuhuu.cloud.common.core.exception;

import com.qiuhuu.cloud.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 * @author : qiuhuu
 * @date : 2020-07-08 11-06
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 捕获自定义异常
     * 不知道
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler({CloudException.class})
    public static ResultBody<String> exception(CloudException ex, HttpServletResponse response) {
        //todo 后续改进
        ResultBody<String> resultBody = new ResultBody<String>().failure(400,ex.getMessage());
        response.setStatus(resultBody.getHttpStatus());
        log.error("捕获到自定义异常：{}，msg:{}",ex.getStackTrace()[0].getClassName(),ex.getMessage());
        return resultBody;
    }

    /**
     * 捕获其他异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public static ResultBody<String> exception(Exception ex) {
        //todo 后续改进
        ResultBody<String> resultBody = new ResultBody<String>().failure(400,ex.getMessage());
        log.error("全局异常："+ex.getMessage());
        return resultBody;
    }
}
