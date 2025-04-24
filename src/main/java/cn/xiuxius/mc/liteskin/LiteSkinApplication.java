package cn.xiuxius.mc.liteskin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
@MapperScan("cn.xiuxius.mc.liteskin.mapper")
public class LiteSkinApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(LiteSkinApplication.class, args);
        ConfigurableEnvironment env = app.getEnvironment();
        log.info("""
                
                ----------------------------------------------------------
                \tApplication '{}' is running! Doc Access URLs:
                \tLocal:\t\thttp://localhost:{}/doc.html
                ----------------------------------------------------------
                
                """,
            env.getProperty("spring.application.name"),
            env.getProperty("server.port"));
    }

}
