package project.exception;

public class MoneyOperationException extends RuntimeException {

    public MoneyOperationException() {
    }

    public MoneyOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
