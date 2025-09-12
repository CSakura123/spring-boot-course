package top.syy.boot.config.service;


import top.syy.boot.config.enums.ResultStatus;
import top.syy.boot.config.model.Mail;

/**
 * @author 小c
 */
public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);
}
