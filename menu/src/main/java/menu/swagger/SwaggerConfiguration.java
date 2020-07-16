package menu.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("ecse005008ef.epam.com:8080/api/menu-service")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(SwaggerMethodToDocument.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiDetails())
                .securitySchemes(Arrays.asList(apiKey()));
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Uber - Coffee API",
                "Project of educational reasons" ,
                "0.1",
                "Free, at least now",
                new springfox.documentation.service.Contact("Philip Yaromenka", "https://www.epam-group.ru", "https://www.proverka@kgb.ru"),
                "Api License",
                "https://www.epam-group.ru",
                Collections.emptyList());
    }

    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}