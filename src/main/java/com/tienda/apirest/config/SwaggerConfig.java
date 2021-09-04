package com.tienda.apirest.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tienda.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
        		.title("Tienda Celulares API REST")
        		.description("API REST for Tienda Celulares.")
        		.version("1.0")
        		.license("Apache License Version 2.0")
        		.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        		.contact(new Contact("Bruno Soares", "https://www.linkedin.com/in/bruno-soares-0b87b415/",
                        "bruno.p.soares@gmail.com"))
        		.build();

        return apiInfo;
    }

}
