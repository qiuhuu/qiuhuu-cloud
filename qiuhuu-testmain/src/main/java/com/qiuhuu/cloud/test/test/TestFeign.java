package com.qiuhuu.cloud.test.test;

import com.qiuhuu.cloud.common.core.model.ResultBody;
import com.qiuhuu.cloud.test.test.hystrix.TestFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : qiuhuu
 * @date : 2020-07-22 15:07
 */
@FeignClient(name = "qiuhuu-test",fallback = TestFeignHystrix.class)
public interface TestFeign {

    @GetMapping("test/port")
    ResultBody aq();

    @GetMapping("test/hystrix/fallback/{id}")
    ResultBody<Long>  testHystrix(@PathVariable("id") String id);
}
