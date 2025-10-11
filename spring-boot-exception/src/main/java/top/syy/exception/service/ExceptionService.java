package top.syy.exception.service;

import org.springframework.stereotype.Service;
import top.syy.exception.exception.BusinessException;

/**
 * @author 小c
 */
@Service
public class ExceptionService {
    public void unAuthorizedError()
    {
        throw new BusinessException("权限不足");
    }
    public void systemError()
    {
        throw new BusinessException("服务器异常");
    }
}
