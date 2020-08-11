package com.qiuhuu.cloud.gateway.controller;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author : qiuhuu
 * @date : 2020-07-08 14-56
 */
@Slf4j
@RestController
public class DefaultHystrixController {

    /**
     * test服务降级处理
     */
    @GetMapping("/fallback/test")
    public Mono<ResultBody> testFallback(){
        log.error("test服务降级操作...");
        return Mono.just(new ResultBody<>().failure(ResultEnum.GATEWAY_TIMEOUT));
    }
}
