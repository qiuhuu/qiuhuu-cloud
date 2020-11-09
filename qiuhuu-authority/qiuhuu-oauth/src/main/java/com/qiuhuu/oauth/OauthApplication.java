package com.qiuhuu.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 任务服务启动类
 * @author : qiuhuu
 * @date : 2020-08-17 14:59
 */
@SpringCloudApplication
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}
