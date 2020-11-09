package com.qiuhuu.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 资源服务器
 * @author : qiuhuu
 * @date : 2020-08-17 15:15
 */
@SpringCloudApplication
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class,args);
    }
}
