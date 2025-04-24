package cn.xiuxius.mc.liteskin.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security")
@Data
public class SecurityProperties {


    private Account account;


    @Data
    public static class Account{
        private String passwordSalt;
        private String jwtKey;
    }



}
