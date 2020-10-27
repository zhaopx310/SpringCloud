package com.customer.feign;

import com.customer.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "PROVIDER-SERVER",configuration = FeignConfiguration.class, fallbackFactory = TestFeignFallback.class)
public interface TestFeign {
    @GetMapping(value = "/getTest")
    String getTest();

    @PostMapping(value = "/postTest")
    String postTest();
}
