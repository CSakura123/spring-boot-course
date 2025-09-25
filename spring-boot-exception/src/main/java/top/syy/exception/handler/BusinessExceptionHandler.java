package top.syy.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.syy.exception.common.Result;
import top.syy.exception.exception.BusinessException;

/**
 * AOP 切面处理
 * @author 小c
 */
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        log.error(e.getMessage(), e);
    }
}
