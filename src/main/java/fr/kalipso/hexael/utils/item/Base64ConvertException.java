package fr.kalipso.hexael.utils.item;


import lombok.NonNull;

public class Base64ConvertException extends RuntimeException {
    private final Exception exception;

    public Base64ConvertException(@NonNull Exception exception) {
        super(exception.getClass().getSimpleName() + ": " + exception.getMessage());
        this.exception = exception;
    }

    public @NonNull Exception getException() {
        return exception;
    }
}