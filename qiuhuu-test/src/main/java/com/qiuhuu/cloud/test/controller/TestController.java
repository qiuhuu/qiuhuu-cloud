package com.qiuhuu.cloud.test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author : qiuhuu
 * @date : 2020-07-07 17-49
 */
@Slf4j
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("test/port")
    public ResultBody aq(){
        return new ResultBody().success(ResultEnum.OK,"test1:"+port);
    }

    @GetMapping("/health")
    public String health(){
        return "health";
    }

    @GetMapping("/test/{msg}")
    public ResultBody test(@PathVariable String msg){
        return new ResultBody().success(ResultEnum.OK,msg+"dsa");
    }

    @GetMapping("fallback")
    public ResultBody testFallback(){
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResultBody<String>().success(ResultEnum.OK,"time out");
    }

    /**
     * 自定义方法的超时熔断时间,优先方法的时间
     * 需要在启动类中加上 @EnableCircuitBreaker 注解
     * fallbackMethod 熔断后进入的方法
     * @param id
     * @return
     */
    @GetMapping("test/hystrix/fallback/{id}")
    @HystrixCommand(fallbackMethod = "testHystrixFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public ResultBody<Long>  testHystrix(@PathVariable String id){
        long startTime = System.currentTimeMillis();
        if ("2".equals(id)){
            int s = 10/0;
        } else if ("1".equals(id)) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis()-startTime;
        return new ResultBody<Long>().success(end);
    }
    public ResultBody<Long>  testHystrixFallback(String id){
        return new ResultBody<Long>().failure(ResultEnum.SERVICE_FALLBACK,Long.valueOf(id));
    }

}
