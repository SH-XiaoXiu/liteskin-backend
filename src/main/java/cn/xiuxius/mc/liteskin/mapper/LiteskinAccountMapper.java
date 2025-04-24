package cn.xiuxius.mc.liteskin.mapper;

import cn.xiuxius.mc.liteskin.entity.LiteskinAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * <p>
 * LiteSkin账户 Mapper 接口
 * </p>
 *
 * @author A_XiaoXiu
 * @since 2025-04-07
 */
public interface LiteskinAccountMapper extends BaseMapper<LiteskinAccount> {

    @Nullable
    LiteskinAccount selectByEmail(@NotNull String email);
}
