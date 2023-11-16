package protein.proteinspring.exception;

public class BadRequestExcpetion extends RuntimeException {
    public BadRequestExcpetion() {
        super();
    }

    public BadRequestExcpetion(String s) {
        super(s);
    }

    public BadRequestExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestExcpetion(Throwable cause) {
        super(cause);
    }
}
