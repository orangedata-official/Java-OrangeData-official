package ru.orangedata.orangelib.network.exception;

public class CreatedNotProceedException extends OrangeException {

    public CreatedNotProceedException() {
        super("Check had been created but has not been proceeded");
    }

}
