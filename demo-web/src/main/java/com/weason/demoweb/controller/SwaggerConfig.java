/**
 * @filename:UserController 2019年5月29日
 * @project demo-parent  0.0.1
 * Copyright(c) 2020 weilei Co. Ltd. 
 * All right reserved. 
 */
package com.weason.demoweb.controller;

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

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 * Swagger核心配置文件
 * ========================
 * @author weilei 
 * @Date   2019年5月29日
 * ========================
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Value("${server.port}")
    private static String port;
    //Swagger扫描的接口路径
	public static String CONTROLLER_URL="com.weason.demoweb.controller";
    //Swagger接口文档标题
	public static String SWAGGER_TITLE="API文档-weilei";
    //Swagger接口文档描述
	public static String SWAGGER_DESCRIPTION="API文档";
    //Swagger接口文档版本
	public static String SWAGGER_VERSION="1.0";
    //Swagger项目服务的URL
	public final static String SWAGGER_URL="http://127.0.0.1:"+port;
	
	//验证的页面http://127.0.0.1:8080/swagger-ui.html
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE)
                .description(SWAGGER_DESCRIPTION)
                .termsOfServiceUrl(SWAGGER_URL)
                .version(SWAGGER_VERSION)
                .build();
    }
}
