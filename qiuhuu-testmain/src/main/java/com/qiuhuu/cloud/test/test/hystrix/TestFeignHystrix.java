package com.qiuhuu.cloud.test.test.hystrix;

import com.qiuhuu.cloud.common.core.constant.ResultEnum;
import com.qiuhuu.cloud.common.core.model.ResultBody;
import com.qiuhuu.cloud.test.test.TestFeign;
import org.springframework.stereotype.Component;

/**
 * @author : qiuhuu
 * @date : 2020-07-23 16:00
 */
@Component
public class TestFeignHystrix implements TestFeign {
    @Override
    public ResultBody aq() {
        return null;
    }

    @Override
    public ResultBody<Long> testHystrix(String id) {
        String msg = "服务熔断";
        return new ResultBody<Long>().failure(ResultEnum.SERVICE_FALLBACK,1L);
    }
}
