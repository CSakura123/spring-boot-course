package top.syy.boot.mp.boot.config.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 小c
 */
@Data
public class Mail {
    @NotBlank
    @Email
    private String sendTo;
    private String subject;
    private String content;
}
