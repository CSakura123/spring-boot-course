package top.syy.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syy.entity.LoginRequest;
import top.syy.entity.LoginResponse;
import top.syy.result.Result;
import top.syy.service.LoginService;
/**
 * @author 小c
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.login(loginRequest);
        return Result.ok(loginResponse);
    }
}
