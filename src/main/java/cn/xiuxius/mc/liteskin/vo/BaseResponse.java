package cn.xiuxius.mc.liteskin.vo;

import cn.xiuxius.mc.liteskin.enumeration.ResponseCode;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class BaseResponse<T> {

    private final ResponseCode code;

    private final String message;

    private final T data;


    public BaseResponse(ResponseCode code, String message, T data) {
        String msg;
        this.code = code;
        if (message == null) {
            msg = code.getDefaultMessage();
        }else {
            msg = message;
        }
        this.message = msg;
        this.data = data;
    }


    public static <T> BaseResponse<T> ok(T data) {
        return new BaseResponse<>(ResponseCode.SUCCESS, null, data);
    }

    public static <T> BaseResponse<T> ok(T data, String message) {
        return new BaseResponse<>(ResponseCode.SUCCESS, message, data);
    }

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<>(ResponseCode.SUCCESS, "success", null);
    }

    public static <T> BaseResponse<T> fail(@NotNull ResponseCode code) {
        return new BaseResponse<>(code, code.getDefaultMessage(), null);
    }

    public static <T> BaseResponse<T> fail(@NotNull ResponseCode code, T data) {
        return new BaseResponse<>(code, code.getDefaultMessage(), data);
    }

    public static <T> BaseResponse<T> fail(@NotNull ResponseCode code, T data, String message) {
        return new BaseResponse<>(code, message, data);
    }

    public static <T> BaseResponse<T> fail(@NotNull ResponseCode code, String message) {
        return new BaseResponse<>(code, message, null);
    }

    public static <T> BaseResponse<T> fail() {
        return new BaseResponse<>(ResponseCode.BAD_REQUEST, null, null);
    }


}
