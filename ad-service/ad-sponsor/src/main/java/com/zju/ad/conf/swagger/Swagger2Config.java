package com.zju.ad.conf.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {
	@Value("${swagger2.enable}") private boolean enable;


	@Bean("广告投放")
	public Docket userApis() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("广告投放系统")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zju.ad.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.enable(enable);
	}
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("广告投放系统接口文档")
                .description("")
                .termsOfServiceUrl("")
                .version("0.1")
                .build();
    }
}
