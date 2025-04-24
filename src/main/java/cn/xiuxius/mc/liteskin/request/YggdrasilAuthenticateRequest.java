package cn.xiuxius.mc.liteskin.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Schema(name = "YggdrasilAuthenticateRequest", description = "登录请求")
public class YggdrasilAuthenticateRequest {


    @Schema(description = "用户名")
    @NotBlank(message = "username cannot be blank")
    private String username;

    @Schema(description = "密码")
    @NotBlank(message = "password cannot be blank")
    private String password;

    @Schema(description = "客户端令牌")
    private String clientToken;

    @Schema(description = "是否在响应中包含用户信息")
    private boolean requestUser = false;

    @Schema(description = "客户端")
    private Agent agent;





    @Data
    @Accessors(chain = true)
    @Schema(name = "YggdrasilAuthenticateRequest-Agent", description = "登录客户端")
    public static class Agent {
        @Schema(description = "客户端名称")
        private String name;
        @Schema(description = "客户端版本")
        private String version;
    }

}
