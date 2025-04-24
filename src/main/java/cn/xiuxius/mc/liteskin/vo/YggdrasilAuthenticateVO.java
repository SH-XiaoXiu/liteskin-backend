package cn.xiuxius.mc.liteskin.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Schema(name = "YggdrasilAuthenticateRequest", description = "登录请求")
public class YggdrasilAuthenticateVO {


    @Schema(description = "新令牌的 accessToken")
    private String accessToken;

    @Schema(description = "新令牌的 clientToken")
    private String clientToken;

    @Schema(description = "用户可用角色列表")
    private List<YggdrasilProfileVO> availableProfiles;

    @Schema(description = "绑定的角色")
    private YggdrasilProfileVO selectedProfile;

    @Schema(description = "用户信息")
    private String user;





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
