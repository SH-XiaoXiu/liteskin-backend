package cn.xiuxius.mc.liteskin.service.liteskin.impl;

import cn.hutool.jwt.JWTUtil;
import cn.xiuxius.mc.liteskin.dto.LiteSkinAccountAuthenticateDTO;
import cn.xiuxius.mc.liteskin.entity.LiteskinAccount;
import cn.xiuxius.mc.liteskin.enumeration.AuthenticationScope;
import cn.xiuxius.mc.liteskin.mapper.LiteskinAccountMapper;
import cn.xiuxius.mc.liteskin.properties.SecurityProperties;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountAuthentication;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LiteSkinAccountServiceImpl implements LiteSkinAccountService {

    private final LiteskinAccountMapper accountMapper;

    private final LiteSkinAccountAuthentication authenticationService;

    private final SecurityProperties securityProperties;

    @Override
    public Optional<LiteSkinAccountAuthenticateDTO> loginByPassword(@NotNull String email, @NotNull String password) {
        LiteskinAccount account = accountMapper.selectByEmail(email);

        if (account == null) {
            return Optional.empty();
        }

        // 验证密码
        boolean success = authenticationService.authPassword(AuthenticationScope.LOGIN, account.getId(), password);

        if (success) {
            Map<String,Object> payload = new HashMap<>();
            String token = JWTUtil.createToken(payload, securityProperties.getAccount().getJwtKey().getBytes(StandardCharsets.UTF_8));
            return Optional.of(new LiteSkinAccountAuthenticateDTO()
                    .setAccountId(account.getId())
                    .setDisplayName(account.getDisplayName())
                    .setEmail(account.getEmail())
                    .setLsToken(token));
        } else {
            return Optional.empty();
        }
    }
}
