package com.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProviderApplication {
    private static final Logger logger = LoggerFactory.getLogger(ProviderApplication.class);
    private static String zport;
    @Value("${server.port}")
    public void setZport(String port) {
        zport = port;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @GetMapping(value = "/getTest")
    public static String getTest(){
        logger.info(zport + " 服务提供者getTest请求成功");
        return zport+" 服务提供者getTest请求成功";
    }

    @GetMapping(value = "/getTestParam")
    public static String getTestParam(String name){
        logger.info("服务提供者getTestParam请求成功：" + name);
        return "服务提供者getTestParam请求成功：" + name;
    }

    @PostMapping(value = "/postTest")
    public static String postTest(){
        logger.info("服务提供者PostTest请求成功");
        return "服务提供者PostTest请求成功";
    }

}
