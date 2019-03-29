package com.code.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weiQiang
 * @date 2018/10/26
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  /**
   * 文件描述
   */
  @Value("${common.swagger.code.description:展示先做基础功能，后面再添加业务}")
  private String codeDescription;
  /**
   * 邮箱
   */
  @Value("${common.swagger.code.email:business@code.com}")
  private String codeEmail;
  /**
   * 作者名称
   */
  @Value("${common.swagger.code.author:code-center}")
  private String codeName;
  /**
   * 文档标题
   */
  @Value("${common.swagger.code.title:基础代码RESTful API}")
  private String codeTitle;
  /**
   * 作者Url
   */
  @Value("${common.swagger.code.url:https://www.code.com.cn/}")
  private String codeUrl;
  /**
   * 版本
   */
  @Value("${common.swagger.code.version:1.0}")
  private String codeVersion;
  /**
   * 开启swagger
   */
  @Value("${common.swagger.code.enable:true}")
  private boolean enableSwagger;
  /**
   * 服务Url
   */
  @Value("${common.swagger.code.service.url:https://www.bonc.com.cn/}")
  private String serviceUrl;

  @Bean
  public Docket createRestApi() {
    List<Parameter> pars = new ArrayList<Parameter>();
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .enable(enableSwagger)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(pars)
            .apiInfo(apiInfo());
  }


  /**
   * 初始化ApiInfo
   *
   * @return ApiInfo
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title(codeTitle)
            .description(codeDescription)
            .termsOfServiceUrl(serviceUrl)
            .version(codeVersion)
            .contact(new Contact(codeName, codeUrl, codeEmail))
            .build();
  }



}
