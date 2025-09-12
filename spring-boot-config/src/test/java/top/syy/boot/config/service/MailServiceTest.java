package top.syy.boot.config.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.syy.boot.config.model.Mail;

@Slf4j
@SpringBootTest
class MailServiceTest {
  @Resource
  private MailService mailService;
  @Test
  void sendSimpleMail() {
    Mail mail = new Mail();
    mail.setSendTo("3068195512@qq.com");
    mail.setSubject("测试邮件");
    mail.setContent("测试邮件内容") ;
    mailService.sendSimpleMail(mail);
  }

}