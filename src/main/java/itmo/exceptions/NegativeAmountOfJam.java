package itmo.exceptions;

public class NegativeAmountOfJam extends Exception{
    public NegativeAmountOfJam(String message) {
        super(message);
    }

    public NegativeAmountOfJam(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeAmountOfJam(Throwable cause) {
        super(cause);
    }
}
