package com.qiuhuu.gateway;

import io.swagger.annotations.SwaggerDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 网关启动类
 * @author : qiuhuu
 * @date : 2020-07-02 11-29
 */
@SpringCloudApplication
@ComponentScan("com.qiuhuu")
@MapperScan("com.qiuhuu.gateway.domain.dao")
public class GatewayApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(GatewayApplication.class,args);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
