package top.syy.boot.config.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syy.boot.config.common.ApiResponse;
import top.syy.boot.config.enums.ResultStatus;
import top.syy.boot.config.model.Mail;
import top.syy.boot.config.service.MailService;

/**
 * @author 小c
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private MailService mailService;
    @PostMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendSimpleMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendSimpleMail(mail);
        if(rs==ResultStatus.SUCCESS){
            return ResponseEntity.ok(ApiResponse.success("发送成功",rs));
        }
        return ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }

}
