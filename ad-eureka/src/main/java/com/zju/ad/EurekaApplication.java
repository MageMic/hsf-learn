package com.zju.ad;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: zjumic
 * @Date: created at 1:11 2019/8/10
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

//    public int NumberOf1(int n) {
//        int count = 0;
//        int flag = 1;
//        while (flag != 0) {
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag <<= 1;
//        }
//        return count;
//    }
}
