//package com.qiuhuu.common.starter.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * swagger2 配置
// * @author : qiuhuu
// * @date : 2020-07-06 14-36
// */
//@Configuration
//@EnableSwagger2
//public class SwaggerAutoConfiguration extends WebMvcConfigurationSupport {
//
//    @Bean
//    public Docket createPcRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("pc")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.qiuhuu"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("swagger RESTful APIs")
//                .description("swagger RESTful APIs")
//                .termsOfServiceUrl("https://www.qiuhuu.com/")
//                .version("1.0")
//                .build();
//    }
//    /**
//     * h5的Swagger页面
//     */
//    @Bean
//    public Docket createH5RestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .groupName("h5")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.qiuhuu"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 添加ResourceHandler
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("doc.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//}
