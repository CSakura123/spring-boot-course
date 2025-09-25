package top.syy.exception.exception;

import lombok.Getter;
import top.syy.exception.enums.ErrorCode;
@Getter
/**
 * @author 小c
 */
public class BusinessException extends RuntimeException{
    private int code;
    private String message;
    public BusinessException(String message) {
        super(message);
        this.message = message;
        this.code = ErrorCode.SERVER_ERROR.getCode();
    }
    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }
    public BusinessException(String message,Throwable e) {
        super(message);
        this.code = ErrorCode.SERVER_ERROR.getCode();
        this.message = message;
    }


}
