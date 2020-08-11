package com.qiuhuu.cloud.test.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author : qiuhuu
 * @date : 2020-07-22 11:40
 */
public interface LoadBalancer {

    /**
     * 获得所有实例
     * @author : qiuhuu
     * @date : 2020/7/22 11:44
     * @param serviceInstanceList:
     * @return org.springframework.cloud.client.ServiceInstance
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
