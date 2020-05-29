package com.zju.edas;

import com.alibaba.boot.hsf.annotation.HSFConsumer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HSFConfig {

    @HSFConsumer(clientTimeout = 3000, serviceVersion = "1.0.0")
    private HelloService helloService;
}
