package cn.xiuxius.mc.liteskin.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.xiuxius.mc.liteskin.properties.SecurityProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RequestHeaderInterceptor implements HandlerInterceptor {

    private final SecurityProperties securityProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return true;
        }
        //解析jwt
        boolean verify = JWTUtil.verify(token, securityProperties.getAccount().getJwtKey().getBytes(StandardCharsets.UTF_8));
        if (verify) {

            JWT jwt = JWTUtil.parseToken(token);

            if (jwt.getPayload("account-id") != null) {
                request.setAttribute("account-id", jwt.getPayload("account-id"));
            }

            if (jwt.getPayload("account-email") != null) {
                request.setAttribute("account-email", jwt.getPayload("account-email"));
            }

            return true;
        } else {
            return true;
        }
    }



}
