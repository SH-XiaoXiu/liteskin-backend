package cn.xiuxius.mc.liteskin.security.account.web;


import cn.xiuxius.mc.liteskin.enumeration.LiteSkinHeader;
import cn.xiuxius.mc.liteskin.exception.MissingLiteSkinHeaderException;
import cn.xiuxius.mc.liteskin.security.account.anno.LSAccountId;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AccountIdMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasAnn = parameter.hasParameterAnnotation(LSAccountId.class);
        boolean supportType = parameter.getParameterType().equals(long.class) || parameter.getParameterType().equals(Long.class);
        return hasAnn && supportType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        LSAccountId anno = parameter.getParameterAnnotation(LSAccountId.class);
        String userIdStr = webRequest.getHeader(LiteSkinHeader.LS_ACCOUNT_ID.getName());
        if (userIdStr == null) {
            if (anno != null && anno.required()) {
                throw new MissingLiteSkinHeaderException(LiteSkinHeader.LS_ACCOUNT_ID.getName(), parameter);
            } else {
                return null;
            }
        }else {
            try {
                return Long.parseLong(userIdStr);
            } catch (NumberFormatException e) {
                String parameterName = parameter.getParameterName();
                if (parameterName == null) parameterName = "Unnamed parameter of type " + parameter.getParameterType().getName();
                throw new MethodArgumentTypeMismatchException(userIdStr, parameter.getParameterType(), parameterName, parameter, e);
            }
        }
    }
}
