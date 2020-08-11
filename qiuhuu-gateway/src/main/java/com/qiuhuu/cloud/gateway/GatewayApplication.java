package com.qiuhuu.cloud.gateway;

import com.qiuhuu.cloud.gateway.filter.CustomGlobalFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 网关启动类
 * @author : qiuhuu
 * @date : 2020-07-02 11-29
 */
@SpringCloudApplication
//@EnableAutoConfiguration(exclude = {SwaggerAutoConfiguration.class})
@ComponentScan("com.qiuhuu.cloud")
@EnableFeignClients
@MapperScan("com.qiuhuu.cloud.gateway.domain.dao")
//@RibbonClient(name = "qiuhuu-test", configuration = RibbonConfig.class)//user-provider
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }
}
