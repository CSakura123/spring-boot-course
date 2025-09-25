package top.syy.service;

import top.syy.entity.LoginRequest;
import top.syy.entity.LoginResponse;

/**
 * @author 小c
 */
public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
