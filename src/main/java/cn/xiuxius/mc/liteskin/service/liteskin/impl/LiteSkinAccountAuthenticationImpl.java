package cn.xiuxius.mc.liteskin.service.liteskin.impl;

import cn.hutool.crypto.digest.DigestUtil;
import cn.xiuxius.mc.liteskin.entity.LiteskinAccountAuthentication;
import cn.xiuxius.mc.liteskin.enumeration.AuthenticationScope;
import cn.xiuxius.mc.liteskin.mapper.LiteskinAccountAuthenticationMapper;
import cn.xiuxius.mc.liteskin.properties.SecurityProperties;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountAuthentication;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiteSkinAccountAuthenticationImpl implements LiteSkinAccountAuthentication {

    private final SecurityProperties securityProperties;

    private final LiteskinAccountAuthenticationMapper authenticationMapper;

    @Override
    public boolean authPassword(@NotNull AuthenticationScope scope, long accountId, @NotNull String password) {
        LiteskinAccountAuthentication authentication = authenticationMapper.selectAuthentication(scope.name(), accountId);
        if (authentication == null) {
            return false;
        }
        String hexPassword = DigestUtil.sha256Hex(password + securityProperties.getAccount().getPasswordSalt(), "UTF-8");
        //暂时不摘要
        return authentication.getCredential().equals(password);
    }
}
