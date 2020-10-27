package com.customer.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestFeignFallback implements FallbackFactory<TestFeign> {

    @Override
    public TestFeign create(Throwable throwable) {
        return new TestFeign() {
            @Override
            public String getTest() {
                return "调用失败-服务降级";
            }

            @Override
            public String postTest() {
                return null;
            }
        };
    }
}
