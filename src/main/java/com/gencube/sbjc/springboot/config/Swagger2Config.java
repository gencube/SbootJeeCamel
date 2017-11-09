package com.gencube.sbjc.springboot.config;

import com.google.common.base.Predicates;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author bpong
 */
@Configuration
@ComponentScan("com.gencube.sbjc")
@EnableSwagger2
public class Swagger2Config extends WebMvcConfigurerAdapter {

    public static final String SPRING_BOOT_PKG = "org.springframework.boot";
    public static final String ERROR_MODEL_REF = "Error";

    public static final String MSG_200 = "Successfully access resource.";
    public static final String MSG_400 = "Bad Request url or format.";
    public static final String MSG_500 = "Internal Server Error.";

    public static final String[] CORS_HOSTS = {"http://localhost:9090", "http://localhost:8080"};

    public static final ModelRef MODEL_REF = new ModelRef(ERROR_MODEL_REF);

    @Bean
    public PropertiesConfig propertiesConfig() {
        return new PropertiesConfig();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.basePackage(SPRING_BOOT_PKG)))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, getDefaultResponseMessage());
    }

    @Bean
    public ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("GCT Server", "", "1.0.0",
                "GCT API terms of service", "gencube@github.com",
                "Gencube Tech Pty. Ltd.",
                "http://www.gct.com/");
        return apiInfo;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // for swagger.
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // for nginx and cross platform cfo.
        CorsRegistration registration = registry.addMapping("/**");
        registration.allowedOrigins(CORS_HOSTS);
    }

    private List<ResponseMessage> getDefaultResponseMessage() {
        return newArrayList(
                new ResponseMessageBuilder()
                        .code(500)
                        .message(MSG_500)
                        .responseModel(MODEL_REF)
                        .build(),
                new ResponseMessageBuilder()
                        .code(400)
                        .message(MSG_400)
                        .responseModel(MODEL_REF)
                        .build()
        );
    }

}
