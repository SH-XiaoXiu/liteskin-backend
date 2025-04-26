package cn.xiuxius.mc.liteskin.service.liteskin.impl;

import cn.xiuxius.mc.liteskin.dto.LiteSkinProfileDTO;
import cn.xiuxius.mc.liteskin.entity.LiteskinProfile;
import cn.xiuxius.mc.liteskin.mapper.LiteskinProfileMapper;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LiteSkinAccountProfileServiceImpl implements LiteSkinAccountProfileService {

    private final LiteskinProfileMapper profileMapper;


    @Override
    public Optional<List<LiteSkinProfileDTO>> getAccountProfiles(long accountId) {

        List<LiteskinProfile> profiles = profileMapper.selectListByAccountId(accountId);

        return Optional.ofNullable(profiles).map(p->p.stream().map(LiteSkinProfileDTO::of).toList());

    }
}
