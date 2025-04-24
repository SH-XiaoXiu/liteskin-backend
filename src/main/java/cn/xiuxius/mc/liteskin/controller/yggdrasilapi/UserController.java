package cn.xiuxius.mc.liteskin.controller.yggdrasilapi;


import cn.xiuxius.mc.liteskin.request.YggdrasilAuthenticateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @see <a href="https://github.com/yushijinhun/authlib-injector/wiki/Yggdrasil-%E6%9C%8D%E5%8A%A1%E7%AB%AF%E6%8A%80%E6%9C%AF%E8%A7%84%E8%8C%83#%E7%94%A8%E6%88%B7%E9%83%A8%E5%88%86">Yggdrasil API 用户部分</a>
 * */

@Slf4j
@RestController("yggdrasil-api-user")
@RequiredArgsConstructor
@RequestMapping("/authserver")
@Tag(name = "yggdrasil-api-user", description = "Yggdrasil API 用户部分")
public class UserController {


    @Operation(summary = "登录")
    @PostMapping("/authenticate")
    public void authenticate(@Validated @RequestBody YggdrasilAuthenticateRequest request) {


    }







}
