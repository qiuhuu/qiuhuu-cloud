package com.qiuhuu.oauth.config;

import com.qiuhuu.cloud.common.core.constant.TimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author : qiuhuu
 * @date : 2020-08-17 10:57
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Resource
    DataSource oauthdb;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RedisTokenStore tokenStore;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * *用来配置令牌端点(Token Endpoint)的安全约束。
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

        security
                //允许客户表单认证
                .allowFormAuthenticationForClients()
                //设置oauth_client_details中的密码编码器
                .passwordEncoder(passwordEncoder)
                .tokenKeyAccess("isAuthenticated()")
                //对于CheckEndpoint控制器[框架自带的校验]的/oauth/check端点允许所有客户端发送器请求而不会被Spring-security拦截
                .checkTokenAccess("permitAll()");
    }

    /**
     * *配置OAuth2的客户端相关信息。使用了数据库存储
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // jdbcTemplate 会查询指定数据源表： oauth_client_details;
        clients.jdbc(oauthdb);
    }

    /**
     * *配置授权服务器端点的属性和增强功能。
     * *设置自定义验证规则， token存储设置使用...
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .tokenServices(defaultTokenServices())
                .userDetailsService(userDetailsService)
                // refreshToken是否可以重复使用。 默认：true;
                .reuseRefreshTokens(false)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        // 是否支持刷新令牌
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setReuseRefreshToken(false);
        // token有效期设置，默认12小时,设置2小时
        tokenServices.setAccessTokenValiditySeconds(TimeConstants.ACCESS_TOKEN_VALID_TIME.intValue());
        //默认30天，这里修改为7天
        tokenServices.setRefreshTokenValiditySeconds(TimeConstants.REFRESH_TOKEN_VALID_TIME.intValue());
        return tokenServices;
    }
}
