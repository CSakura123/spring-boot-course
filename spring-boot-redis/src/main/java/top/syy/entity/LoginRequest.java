package top.syy.entity;

import lombok.Data;

/**
 * @author 小c
 */
@Data
public class LoginRequest {
    private String phone;
    private String code;
}
