package cn.xiuxius.mc.liteskin.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.xiuxius.mc.liteskin.enumeration.LiteSkinHeader;
import cn.xiuxius.mc.liteskin.properties.SecurityProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class RequestHeaderInterceptor implements HandlerInterceptor {

    private final SecurityProperties securityProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {

        //先清除所有ls的头

        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            if (headerName.startsWith("ls-")) {
                request.removeAttribute(headerName);
            }
        });

        String bearerAuth = request.getHeader("Authorization");
        String token = bearerAuth == null ? null : bearerAuth.replace("Bearer ", "");
        if (token == null || token.isEmpty()) {
            return true;
        }
        //解析jwt
        boolean verify = JWTUtil.verify(token, securityProperties.getAccount().getJwtKey().getBytes(StandardCharsets.UTF_8));
        if (verify) {

            JWT jwt = JWTUtil.parseToken(token);

            if (jwt.getPayload("accountId") != null) {
                request.setAttribute(LiteSkinHeader.LS_ACCOUNT_ID.getName(), jwt.getPayload("accountId"));
            }

            if (jwt.getPayload("accountEmail") != null) {
                request.setAttribute(LiteSkinHeader.LS_ACCOUNT_EMAIL.getName(), jwt.getPayload("accountEmail"));
            }

        }
        return true;
    }



}
