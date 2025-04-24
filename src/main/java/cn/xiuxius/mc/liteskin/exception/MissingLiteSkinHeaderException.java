package cn.xiuxius.mc.liteskin.exception;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingRequestHeaderException;

public class MissingLiteSkinHeaderException extends MissingRequestHeaderException {
    public MissingLiteSkinHeaderException(String headerName, MethodParameter parameter) {
        super(headerName, parameter);
    }

    public MissingLiteSkinHeaderException(String headerName, MethodParameter parameter, boolean missingAfterConversion) {
        super(headerName, parameter, missingAfterConversion);
    }
}
