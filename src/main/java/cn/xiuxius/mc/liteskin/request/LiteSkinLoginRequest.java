package cn.xiuxius.mc.liteskin.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Schema(description = "LiteSkin登录请求")
public class LiteSkinLoginRequest {

    @Schema(description = "登录身份")
    private String principal;

    @Schema(description = "登录凭证")
    private String credential;


}
