package cn.xiuxius.mc.liteskin.vo.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinAccountAuthenticateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(chain = true)
@Schema(description = "LiteSkin登录结果")
public class LiteSkinLoginVO {

    private Long accountId;

    private String displayName;

    private String lsToken;



    public static LiteSkinLoginVO of(@NotNull LiteSkinAccountAuthenticateDTO dto) {
        return new LiteSkinLoginVO()
                .setAccountId(dto.getAccountId())
                .setDisplayName(dto.getDisplayName())
                .setLsToken(dto.getLsToken());
    }

}
