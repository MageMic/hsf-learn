package com.zju.edas;

import com.alibaba.boot.hsf.annotation.HSFProvider;
import com.taobao.pandora.boot.PandoraBootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HSFProviderApplication {

    public static void main(String[] args) {
        PandoraBootstrap.run(args);
        SpringApplication.run(HSFProviderApplication.class, args);
        // 标记服务启动完成，并设置线程 wait。防止业务代码运行完毕退出后，导致容器退出
        PandoraBootstrap.markStartupAndWait();
    }
}
