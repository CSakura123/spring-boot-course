package top.syy.boot.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syy.boot.config.enums.ExpressStstus;

/**
 * @author 小c
 */
@RestController
@RequestMapping("/express")
public class ExpressStstusController {
    @GetMapping("/{status}")
    public String getExpressStatus(@PathVariable ExpressStstus status) {
        return "当前快递状态"+status.getLabel();
    }

}
