package cn.xiuxius.mc.liteskin.security.account.web;


import cn.xiuxius.mc.liteskin.enumeration.LiteSkinHeader;
import cn.xiuxius.mc.liteskin.exception.MissingLiteSkinHeaderException;
import cn.xiuxius.mc.liteskin.security.account.anno.LSAccount;
import cn.xiuxius.mc.liteskin.security.account.model.CurrentAccount;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(CurrentAccount.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        LSAccount anno = parameter.getParameterAnnotation(LSAccount.class);
        String accountIdStr = webRequest.getHeader(LiteSkinHeader.LS_ACCOUNT_ID.getName());
        String accountEmail = webRequest.getHeader(LiteSkinHeader.LS_ACCOUNT_EMAIL.getName());


        List<String> missingFields = new ArrayList<>();
        if (accountIdStr == null) missingFields.add("account-id");
        if (accountEmail == null) missingFields.add("account-email");


        if (anno == null || anno.fullRequired()) {
            if (!missingFields.isEmpty()) {
                throw new MissingLiteSkinHeaderException(missingFields.toString(), parameter);
            }
        }

        if (accountIdStr == null && anno.idRequired()) {
            throw new MissingLiteSkinHeaderException(LiteSkinHeader.LS_ACCOUNT_ID.getName(), parameter);

        }
        if (accountEmail == null && anno.emailRequired()) {
            throw new MissingLiteSkinHeaderException(LiteSkinHeader.LS_ACCOUNT_EMAIL.getName(), parameter);

        }

        CurrentAccount currentAccount = new CurrentAccount();

        if (accountIdStr != null) {
            currentAccount.setId(parseLong(accountIdStr, parameter));
        }

        if (accountEmail != null) {
            currentAccount.setEmail(accountEmail);
        }


        return currentAccount;

    }

    private long parseLong(String str, MethodParameter parameter) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            String parameterName = parameter.getParameterName();
            if (parameterName == null)
                parameterName = "Unnamed parameter of type " + parameter.getParameterType().getName();
            throw new MethodArgumentTypeMismatchException(str, parameter.getParameterType(), parameterName, parameter, e);
        }
    }


}
