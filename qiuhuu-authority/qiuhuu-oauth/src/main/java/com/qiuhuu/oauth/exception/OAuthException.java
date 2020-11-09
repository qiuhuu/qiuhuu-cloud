package com.qiuhuu.oauth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author : qiuhuu
 * @date : 2020-08-19 10:37
 */
@JsonSerialize
public class OAuthException extends OAuth2Exception {
    public OAuthException(String msg) {
        super(msg);
    }
}
