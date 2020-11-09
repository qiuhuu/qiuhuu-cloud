package com.qiuhuu.cloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *
 * hystrix 应用启动类
 * @author : qiuhuu
 * @date : 2020-08-26 15:09
 *
 * EnableHystrixDashboard 开启仪表盘
 */
@SpringCloudApplication
@EnableHystrixDashboard
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }
}
