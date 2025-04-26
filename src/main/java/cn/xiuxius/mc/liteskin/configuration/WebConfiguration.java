package cn.xiuxius.mc.liteskin.configuration;

import cn.xiuxius.mc.liteskin.interceptor.RequestHeaderInterceptor;
import cn.xiuxius.mc.liteskin.security.account.web.AccountIdMethodArgumentResolver;
import cn.xiuxius.mc.liteskin.security.account.web.AccountMethodArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {


    private final AccountMethodArgumentResolver accountMethodArgumentResolver;

    private final AccountIdMethodArgumentResolver accountIdMethodArgumentResolver;

    private final RequestHeaderInterceptor headerInterceptor;


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(accountMethodArgumentResolver);
        resolvers.add(accountIdMethodArgumentResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor);
    }
}
