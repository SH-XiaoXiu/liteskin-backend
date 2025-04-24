package cn.xiuxius.mc.liteskin.service.liteskin;

import cn.xiuxius.mc.liteskin.enumeration.AuthenticationScope;
import org.jetbrains.annotations.NotNull;

public interface LiteSkinAccountAuthentication {
    /**
     * 验证密码
     * @param scope 验证使用范围
     * @see AuthenticationScope
     * @param accountId 账户ID
     * @param password 密码
     * @return 是否验证成功
     */
    boolean authPassword(@NotNull AuthenticationScope scope, long accountId, @NotNull String password);
}
