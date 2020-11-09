package com.qiuhuu.oauth.service;

import com.qiuhuu.cloud.common.core.security.QcUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author : qiuhuu
 * @date : 2020-08-17 15:38
 */
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //数据库中获取user
        QcUserDetails userDetails = new QcUserDetails();
        userDetails.setUsername(username);
        return userDetails;
    }
}
