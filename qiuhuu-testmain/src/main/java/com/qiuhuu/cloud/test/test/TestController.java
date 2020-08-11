package com.qiuhuu.cloud.test.test;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : qiuhuu
 * @date : 2020-07-22 15:06
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    private TestFeign feign;

    @GetMapping("gw")
    public ResultBody gw(){
        ResultBody aq = feign.aq();
        return new ResultBody().success(ResultEnum.OK,aq);
    }

    @GetMapping("gw/{id}")
    public ResultBody<Long> hf(@PathVariable("id") String id){
        ResultBody<Long> hf = feign.testHystrix(id);
        return hf;
    }
}
