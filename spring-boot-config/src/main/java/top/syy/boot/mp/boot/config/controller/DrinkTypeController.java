package top.syy.boot.mp.boot.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syy.boot.mp.boot.config.enums.DrinkType;

/**
 * @author 小c
 */
@RestController
@RequestMapping("/DrinkType")
public class DrinkTypeController {
        @GetMapping("/{drink}")
        public String getExpressStatus(@PathVariable DrinkType drink) {
            return "您的选择是"+drink.getType()+"，价格是"+drink.getPrice();
        }


}

