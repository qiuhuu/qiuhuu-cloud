package com.qiuhuu.common.core.config;

import com.qiuhuu.common.core.serializer.FastJson2JsonRedisSerializer;
import com.qiuhuu.common.core.template.RedisTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * redis 缓存配置
 * @author : qiuhuu
 * @date : 2020-07-02 14-41
 */
@Configuration
@Slf4j
public class RedisAutoConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    /**
     * jedis连接配置
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPort(redisProperties.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        //构建客户端配置
        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration =
                JedisClientConfiguration.builder();

        jedisClientConfiguration.connectTimeout(Duration.ofMillis(redisProperties.getTimeout().toMillis()));
        //配置连接工厂
        JedisConnectionFactory factory = new JedisConnectionFactory(
                redisStandaloneConfiguration,jedisClientConfiguration.build());
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        log.info("RedisTemplate实例化成功！");
        RedisTemplate redisTemplate = new RedisTemplate();
        initRedisTemplate(redisTemplate,redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 引入自定义序列化
     */
    @Bean
    public RedisSerializer fastJson2JsonRedisSerializer() {
        return new FastJson2JsonRedisSerializer<Object>(Object.class);
    }

    /**
     * 设置数据存入 redis 的序列化方式
     */
    private void initRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
        // 开启事务  注意jedis自增不支持事务操作，关闭redis事务
        // redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }
}
