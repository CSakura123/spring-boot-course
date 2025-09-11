package top.syy.boot.config.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.syy.boot.config.model.Team;

/**
 * @author 小c
 */
@RestController
@RequestMapping("/teams")
@Slf4j
public class TeamController {
    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        log.info("创建团队:{}",team);
        return team;
    }
}
