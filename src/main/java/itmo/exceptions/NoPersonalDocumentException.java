package itmo.exceptions;

public class NoPersonalDocumentException extends RuntimeException{
    public NoPersonalDocumentException(String message) {
        super(message);
    }

    public NoPersonalDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPersonalDocumentException(Throwable cause) {
        super(cause);
    }
}
