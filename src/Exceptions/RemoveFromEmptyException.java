package Exceptions;

public class RemoveFromEmptyException extends RuntimeException{
    public RemoveFromEmptyException(String message) {
        super(message);
    }
}
