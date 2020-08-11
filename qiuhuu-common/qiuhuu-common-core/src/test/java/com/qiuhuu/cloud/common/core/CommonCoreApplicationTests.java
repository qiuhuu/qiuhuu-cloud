package com.qiuhuu.cloud.common.core;

import com.qiuhuu.cloud.common.core.util.DatabaseDocumentGenerateUtils;
import com.qiuhuu.cloud.common.core.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CommonCoreApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Date afterWeek = DateUtils.getAfterWeek(date);
        System.out.println(afterWeek);
        String s = DateUtils.formatTextFromtoday(afterWeek);
        System.out.println(s);
    }

}
