package com.example.springnatvkg.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2 {
    public static final String Channels="Таблицы";
    public static final String Days="Дни";
    public static final String Discounts="Скидки";
    public static final String OrderDetails="Детали заявки";
    public static final String Orders="Заявки";
    public static final String Prices="Цена";



    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.springnatvkg.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag(Channels,""))
                .tags(new Tag(Days,""))
                .tags(new Tag(Discounts,""))
                .tags(new Tag(OrderDetails,""))
                .tags(new Tag(Orders,""))
                .tags(new Tag(Prices,""));

    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("NaTvKg")
                .description("Размешение рекламы")
                .version("1.0.0")
                .build();
    }
}
