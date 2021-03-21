package com.ixnah.blog.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Value("${swagger.enable}")
  private boolean enable;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.OAS_30)
      .enable(enable)
      .apiInfo(getApiInfo())
      .select()
      .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
      .title("接口")
      .version("1.0")
      .build();
  }
}
