package cn.xiuxius.mc.liteskin.service.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinAccountAuthenticateDTO;
import cn.xiuxius.mc.liteskin.vo.liteskin.LiteSkinLoginVO;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface LiteSkinAccountService {
    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return 登录结果
     * @see LiteSkinLoginVO
     */
    Optional<LiteSkinAccountAuthenticateDTO> loginByPassword(@NotNull String email, @NotNull String password);
}
