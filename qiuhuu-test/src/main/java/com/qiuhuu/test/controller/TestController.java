package com.qiuhuu.test.controller;

import com.qiuhuu.common.core.constants.ResultEnum;
import com.qiuhuu.common.core.model.ResultBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : qiuhuu
 * @date : 2020-07-07 17-49
 */
@RestController
public class TestController {

    @GetMapping("/health")
    public String health(){
        return "health";
    }

    @GetMapping("/test/{msg}")
    public ResultBody test(@PathVariable String msg){
        return new ResultBody().success(ResultEnum.OK,msg);
    }

    @GetMapping("fallback")
    public ResultBody testFallback(){
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultBody().success(ResultEnum.OK,"time out");
    }
}
