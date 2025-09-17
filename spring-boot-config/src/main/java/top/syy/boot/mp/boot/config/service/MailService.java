package top.syy.boot.mp.boot.config.service;


import top.syy.boot.mp.boot.config.enums.ResultStatus;
import top.syy.boot.mp.boot.config.model.Mail;

/**
 * @author 小c
 */
public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);
}
