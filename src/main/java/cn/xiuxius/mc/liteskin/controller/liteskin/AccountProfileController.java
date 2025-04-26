package cn.xiuxius.mc.liteskin.controller.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinProfileDTO;
import cn.xiuxius.mc.liteskin.enumeration.ResponseCode;
import cn.xiuxius.mc.liteskin.security.account.anno.LSAccountId;
import cn.xiuxius.mc.liteskin.service.liteskin.LiteSkinAccountProfileService;
import cn.xiuxius.mc.liteskin.vo.BaseResponse;
import cn.xiuxius.mc.liteskin.vo.liteskin.LiteSkinProfileVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController("liteskin-api-account-profile")
@RequiredArgsConstructor
@RequestMapping("/liteskin/account/profile")
@Tag(name = "liteskin-api-account-profile", description = "LiteSkin 游戏角色 API")
public class AccountProfileController {


    private final LiteSkinAccountProfileService profileService;


    @GetMapping("/list")
    public BaseResponse<List<LiteSkinProfileVO>> listProfiles(@LSAccountId Long accountId) {

        Optional<List<LiteSkinProfileDTO>> result = profileService.getAccountProfiles(accountId);

        return result.map(r->BaseResponse.ok(r.stream().map(LiteSkinProfileVO::of).toList())).orElseGet(() -> BaseResponse.fail(ResponseCode.ACCOUNT_NOT_EXIST));
    }



}
