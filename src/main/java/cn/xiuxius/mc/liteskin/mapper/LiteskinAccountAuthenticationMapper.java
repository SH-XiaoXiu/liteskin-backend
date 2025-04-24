package cn.xiuxius.mc.liteskin.mapper;

import cn.xiuxius.mc.liteskin.entity.LiteskinAccountAuthentication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 * 账户认证 Mapper 接口
 * </p>
 *
 * @author A_XiaoXiu
 * @since 2025-04-08
 */
public interface LiteskinAccountAuthenticationMapper extends BaseMapper<LiteskinAccountAuthentication> {

    LiteskinAccountAuthentication selectAuthentication(@NotNull String scope, long accountId);
}
