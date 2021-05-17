package com.hanmaum.counseling.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("Authorization") //헤더 이름
                .description("Access Tocken으로 로그인하면 발급됩니다. 앞에 꼭 \"Bearer \" 붙여주세요.") //설명
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Authentication.class)
                .globalOperationParameters(parameters)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @ApiModel
    @Getter
    @Setter
    static class Page{
        @ApiParam(value="페이지 번호(0~N)", example = "0")
        private Integer page;

        @ApiParam(value="한 페이지에서 받을 크기(min = 1)", example = "10")
        private Integer size;

        @ApiParam(value="정렬")
        private List<String> sort;

    }
}