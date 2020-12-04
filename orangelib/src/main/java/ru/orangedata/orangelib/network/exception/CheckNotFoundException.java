package ru.orangedata.orangelib.network.exception;

public class CheckNotFoundException extends OrangeException {
    public CheckNotFoundException() {
        super("No check found");
    }
}
