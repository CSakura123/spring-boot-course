package top.syy.result;

import lombok.Data;
import top.syy.enums.ErrorCode;

/**
 * @author 小c
 */

@Data
public class Result<T> {
    private Integer code=0;
    private String msg="success";
    private T data;
    public static <T> Result<T> ok() {
        return ok( null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error() {
        return error(ErrorCode.SERVER_ERROR);

    }
    public static <T> Result<T> error(ErrorCode errorCode) {
        Result<T> result = new Result<>();
        result.setCode(errorCode.getCode());
        return result;
    }


    public static <T> Result<T> fail(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }
}
