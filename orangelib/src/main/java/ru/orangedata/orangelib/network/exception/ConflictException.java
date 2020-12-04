package ru.orangedata.orangelib.network.exception;

public class ConflictException extends OrangeException {
    public ConflictException(String id) {
        super("Document with id \"" + id + "\" already exists");
    }
}
