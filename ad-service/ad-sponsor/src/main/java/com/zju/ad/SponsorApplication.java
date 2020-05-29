package com.zju.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zjumic
 * @Date: created at 23:37 2019/9/20
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableEurekaClient
@EnableSwagger2
public class SponsorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class);
    }
}
