package top.syy.service;

import org.springframework.stereotype.Service;
import top.syy.entity.LoginRequest;
import top.syy.entity.LoginResponse;

/**
 * @author 小c
 */
@Service
public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
