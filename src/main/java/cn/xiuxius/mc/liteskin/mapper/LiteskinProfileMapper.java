package cn.xiuxius.mc.liteskin.mapper;

import cn.xiuxius.mc.liteskin.entity.LiteskinProfile;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author A_XiaoXiu
 * @since 2025-04-07
 */
public interface LiteskinProfileMapper extends BaseMapper<LiteskinProfile> {

    /**
     * 根据账号ID查询角色列表
     * @param accountId 账号ID
     * @return 角色列表
     */
    List<LiteskinProfile> selectListByAccountId(long accountId);
}
