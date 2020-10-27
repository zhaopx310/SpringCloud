package com.customer.controller;

import com.customer.feign.TestFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Value("${server.port}")
    private String port;
    @Autowired
    private TestFeign testFeign;
    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0 */1 * * * ?")
    @GetMapping(value = "getTest")
    public String getTest(){
        String test = testFeign.getTest();
        logger.info("getTest-feign消费者调用提供者返回数据："+test);
        return test;
        //String restTemplateString = restTemplate.getForObject("http://PROVIDER-SERVER/getTest", String.class);
        //String restTemplateString=restTemplate.getForObject("http://PROVIDER/getTest?name="+name,String.class);
        //System.out.println("getTest-restTemplate消费者调用提供者返回数据："+restTemplateString);
        //return test;
    }

    @PostMapping(value = "postTest")
    public String postTest(){
        String s = testFeign.postTest();
        logger.info("postTest-feign消费者调用提供者返回数据："+s);
        return s;
    }



}
