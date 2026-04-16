package Errors;

public class NoFileDetected extends RuntimeException {
    public NoFileDetected(String message) {
        super(message);
    }
}
