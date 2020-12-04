package ru.orangedata.orangelib.network.exception;

public class OrangeException extends Throwable {

    public OrangeException(String message) {
        super(message);
    }

    public OrangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrangeException(Throwable cause) {
        super(cause);
    }

}
