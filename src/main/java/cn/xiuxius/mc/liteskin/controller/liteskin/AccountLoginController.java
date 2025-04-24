package cn.xiuxius.mc.liteskin.controller.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinAccountAuthenticateDTO;
import cn.xiuxius.mc.liteskin.enumeration.ResponseCode;
import cn.xiuxius.mc.liteskin.request.LiteSkinLoginRequest;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountService;
import cn.xiuxius.mc.liteskin.vo.BaseResponse;
import cn.xiuxius.mc.liteskin.vo.LiteSkinLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@Slf4j
@RestController("liteskin-api-account")
@RequiredArgsConstructor
@RequestMapping("/liteskin/account/login")
@Tag(name = "liteskin-api-account", description = "LiteSkin 账户登录 API")
public class AccountLoginController {


    private final LiteSkinAccountService liteSkinAccountService;

    @Operation(summary = "通过密码")
    @PostMapping("/byPassword")
    public BaseResponse<LiteSkinLoginVO> loginByPassword(@Validated @RequestBody LiteSkinLoginRequest request) {
        Optional<LiteSkinAccountAuthenticateDTO> result = liteSkinAccountService.loginByPassword(request.getPrincipal(), request.getCredential());
        return result
            .map(r -> BaseResponse.ok(LiteSkinLoginVO.of(r)))
            .orElseGet(() -> BaseResponse.fail(ResponseCode.AUTHENTICATION_FAILED));
    }



}
