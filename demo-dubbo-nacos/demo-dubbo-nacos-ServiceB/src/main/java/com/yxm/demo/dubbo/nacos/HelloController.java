package com.yxm.demo.dubbo.nacos;

import com.yxm.demo.dubbo.nacos.api.ServiceA;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "1.0.0",
            interfaceClass = ServiceA.class,
            cluster = "failfast")
    private ServiceA serviceA;

    @GetMapping("/greet")
    public String  greet(String name){
       return serviceA.greet(name);
    }
}
