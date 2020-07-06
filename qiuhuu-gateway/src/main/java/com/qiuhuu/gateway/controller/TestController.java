package com.qiuhuu.gateway.controller;

import com.qiuhuu.common.core.constants.ResultEnum;
import com.qiuhuu.common.core.model.ResultBody;
import com.qiuhuu.gateway.domain.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author : qiuhuu
 * @date : 2020-07-06 16-32
 */
@RestController
@Slf4j
@Api(value = "Test接口",tags = {"测试接口"})
public class TestController {

    @ApiOperation(value = "测试接口")
    @GetMapping("hello")
    public ResultBody hello(@ApiParam(value = "消息",required = true) String msg){
        User user = new User();
        user.setUserName("张三");
        user.setAge(12);

        User user1 = new User();
        user1.setUserName("李思");
        user.setAge(13);

        ArrayList<User> users = new ArrayList<>(2);
        users.add(user);
        users.add(user1);
        return new ResultBody().success(ResultEnum.OK.getCode(),msg,users);
    }
}