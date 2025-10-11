package top.syy.exception.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.syy.exception.common.Result;
import top.syy.exception.entity.User;
import top.syy.exception.service.ExceptionService;


    /**
     * @author 小c
     */
    @RestController
    @RequestMapping("/test")
    public class TestController {
        @Resource
        private ExceptionService exceptionService;

        @GetMapping("/{id}")
        public Result<String> getUserById(@PathVariable Integer id){
            if (id == 0){
                exceptionService.unAuthorizedError();
            }else if (id == 1){
                exceptionService.systemError();
            }else{
//                int n = 1/0;
                return Result.ok("success");
            }
            return Result.ok("success");
        }
        @PostMapping("/user")
        public Result<?> addUser(@Valid @RequestBody User user, BindingResult bindingResult){
            if (bindingResult.hasErrors()){
                return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
            }
            return Result.ok(user);
        }
    }

