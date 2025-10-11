package top.syy.exception;

import top.syy.enums.ErrorCode;

/**
 * @author 小c
 */
public class ServerException extends RuntimeException{
    private int code;
    private String message;
    public ServerException(String message) {
        super(message);
        this.message = message;
        this.code = ErrorCode.SERVER_ERROR.getCode();
    }
    public ServerException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }
    public ServerException(String message, Throwable e) {
        super(message);
        this.code = ErrorCode.SERVER_ERROR.getCode();
        this.message = message;
    }



}
