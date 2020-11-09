package com.qiuhuu.cloud.common.core.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 用于存储用户信息
 * @author : hu yang
 * @date : 2020-10-12 11:31
 */
@Data
public class QcUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String userId;
    public QcUserDetails() {
        super();
    }

    public QcUserDetails(String username, String password, String userId) {
        super();
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //Role role = new Role();
        //return role.getRoles();
        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
