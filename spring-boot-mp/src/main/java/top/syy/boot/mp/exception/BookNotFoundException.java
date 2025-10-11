package top.syy.boot.mp.exception;

/**
 * @author 小c
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
