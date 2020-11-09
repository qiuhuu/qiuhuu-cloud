package com.qiuhuu.cloud.common.core.util;

import com.qiuhuu.cloud.common.core.security.QcUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

/**
 *
 * @author : hu yang
 * @date : 2020-10-12 11:15
 */
public class QCHelper {
    /**
     * 获取认证用户信息
     * @return
     */
    public static QcUserDetails getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof QcUserDetails) {
                return (QcUserDetails) authentication.getPrincipal();
            }
            if (authentication.getPrincipal() instanceof Map) {
                return BeanConvertUtils.mapToObject((Map) authentication.getPrincipal(), QcUserDetails.class);
            }
        }
        return null;
    }
}
