package com.customer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Swagger测试类")
public class SwaggerTestController {

    @ApiOperation(value = "getSwaggerTest-请求测试")
    @GetMapping(value = "getSwaggerTest")
    public String getSwaggerTest(@RequestParam("name") String name){
        System.out.println("getSwaggerTest：" + name);
        return "getSwaggerTest：" + name;
    }

}
