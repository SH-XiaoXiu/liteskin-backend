package cn.xiuxius.mc.liteskin.enumeration;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    SUCCESS(HttpStatus.OK,"success"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"bad request"),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED,"authentication failed");




    private final HttpStatus httpStatus;

    private final String defaultMessage;


    ResponseCode(HttpStatus httpStatus, String defaultMessage) {
        this.httpStatus = httpStatus;
        this.defaultMessage = defaultMessage;
    }


}
