package com.qiuhuu.cloud.common.core.exception;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        if (log.isErrorEnabled()) {
            StackTraceElement stackTrace = ex.getStackTrace()[0];
            log.error("业务异常：{},位置：{},行号:{},详情：{}",ex.getCode(),stackTrace.getClassName(),
                    stackTrace.getLineNumber(),ex.getMessage());
        }
        return resultBody;
    }

    /**
     * 参数校验异常
     * @author qiuhuu
     * @date 2020/10/12 14:34
     * @param e
     * @return com.qiuhuu.cloud.common.core.model.ResultBody<java.lang.String>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBody<String> notValidException(MethodArgumentNotValidException e){
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError allError : allErrors) {
            sb.append(allError.getDefaultMessage()+",");
        }
        sb.deleteCharAt(sb.length()-1);
        if (log.isErrorEnabled()) {
            log.error("参数校验异常：{}",sb);
        }
        return new ResultBody<String>().failure(ResultEnum.PARAMETER_VERIFICATION_ERROR,sb.toString());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResultBody<String> badCredentialsException(BadCredentialsException e){
        if (log.isErrorEnabled()) {
            log.error("认证失败：{}",e.getMessage());
        }
        return new ResultBody<String>().failure(401,e.getMessage(),"登录失败", HttpStatus.UNAUTHORIZED.value());
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
