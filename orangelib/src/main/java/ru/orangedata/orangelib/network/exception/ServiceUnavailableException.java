package ru.orangedata.orangelib.network.exception;

public class ServiceUnavailableException extends OrangeException {
    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
