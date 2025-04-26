package cn.xiuxius.mc.liteskin.service.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinProfileDTO;

import java.util.List;
import java.util.Optional;

public interface LiteSkinAccountProfileService {
    /**
     * 根据账户ID获取角色列表
     * @param accountId 账户ID
     * @return 角色列表
     */
    Optional<List<LiteSkinProfileDTO>> getAccountProfiles(long accountId);
}
