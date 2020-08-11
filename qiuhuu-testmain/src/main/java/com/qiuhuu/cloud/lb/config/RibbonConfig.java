package com.qiuhuu.cloud.lb.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 负载均衡配置
 * @author : qiuhuu
 * @date : 2020-07-14 17-31
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        //随机策略
        return new RandomRule();
    }

}
