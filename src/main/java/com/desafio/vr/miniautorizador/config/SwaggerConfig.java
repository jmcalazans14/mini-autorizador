package com.desafio.vr.miniautorizador.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;


import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ResponseMessage;


@EnableSwagger2
@Configuration
public class SwaggerConfig   {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.desafio.vr.miniautorizador.controller"))             
        .build()
        .useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {        

        

        return new ApiInfoBuilder()
                .title("DESAFIO VR")
                .description("\"Mini Autenticador\"")
                .version("1.0.0")  
                .contact(new Contact("Jefferson Mota Calazans", null, "j.motacalazans@gmail.com"))                
                .build();       
        
    }

    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {
            private static final long serialVersionUID = 1L;

            {
            add(new ResponseMessageBuilder()   
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("Error"))
                .build());
            add(new ResponseMessageBuilder() 
                .code(403)
                .message("Forbidden!")
                .build());
        }};       
        
    } 
    

    //http://localhost:8888/swagger-ui.html 
       
}