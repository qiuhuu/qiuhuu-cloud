package com.qiuhuu.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关启动类
 * @author : qiuhuu
 * @date : 2020-07-02 11-29
 */
@SpringCloudApplication
//@EnableAutoConfiguration(exclude = {SwaggerAutoConfiguration.class})
@ComponentScan("com.qiuhuu")
@MapperScan("com.qiuhuu.gateway.domain.dao")
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
