package cn.xiuxius.mc.liteskin.configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
            .title("LiteSkin")
            .description("LiteSkin API");
        return new OpenAPI()
            .info(info);
    }

}
