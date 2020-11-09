package com.qiuhuu.oauth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * 临时用户类，后面替换为 真实用户类
 * @author qiuhuu
 * @date 2020/09/06 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomUser implements AuthenticatedPrincipal, Serializable {

    /**
     * 昵称
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getName() {
        // 返回经过身份验证的名称（账号唯一标识），可以是用户ID，这里采用手机号
        return mobile;
    }
}
