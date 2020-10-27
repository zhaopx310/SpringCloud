package com.customer.configuration;

import com.customer.feign.TestFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration     //证明这个类是一个配置文件
@EnableScheduling  //启用定时器
public class EnableSchedulingCofig {
    private static final Logger logger = LoggerFactory.getLogger(EnableSchedulingCofig.class);
    @Autowired
    private TestFeign testFeign;

    @Scheduled(cron = "0 */1 * * * ?")
    @GetMapping(value = "getTest")
    public String getTest(){
        String test = testFeign.getTest();
        logger.info("getTest-feign消费者调用提供者返回数据："+test);
        return test;
    }
}
