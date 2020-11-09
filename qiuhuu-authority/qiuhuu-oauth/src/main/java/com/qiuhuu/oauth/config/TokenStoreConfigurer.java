package com.qiuhuu.oauth.config;

import com.qiuhuu.oauth.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.KeyPair;
import java.util.Collection;
import java.util.Map;

/**
 * @author : qiuhuu
 * @date : 2020-09-07 10:11
 */
@Configuration
public class TokenStoreConfigurer {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    KeyProperties keyProperties(){
        return new KeyProperties();
    }

    /**
     * <p>设置令牌存储方式</p>
     * InMemoryTokenStore 在内存中存储令牌。
     * RedisTokenStore 在Redis缓存中存储令牌。
     * JwkTokenStore 支持使用JSON Web Key (JWK)验证JSON Web令牌(JwT)的子Web签名(JWS)
     * JwtTokenStore 不是真正的存储，不持久化数据，身份和访问令牌可以相互转换。
     * JdbcTokenStore 在数据库存储，需要创建相应的表存储数据
     */
    @Bean
    public RedisTokenStore tokensStore(){
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix("oauth:");
        return tokenStore;
    }
}
