package com.qiuhuu.cloud.gateway.controller;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务控制器
 * @author : qiuhuu
 * @date : 2020-07-22 11:32
 */
@Slf4j
@RestController
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation("获取所有服务")
    @GetMapping
    public ResultBody getService(){
        List<String> services = discoveryClient.getServices();
        return new ResultBody().success(ResultEnum.OK,services);
    }

    @ApiOperation("获取服务的全部实例")
    @GetMapping("{serviceName}")
    public ResultBody getServiceInstances(@PathVariable String serviceName){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
        return new ResultBody().success(ResultEnum.OK,instances);
    }

}
