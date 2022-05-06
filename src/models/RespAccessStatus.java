package models;

import java.util.List;

public class RespAccessStatus {
    public List<String> errors;

    public RespAccessStatus(List<String> errors){
        this.errors=errors;
    }
}
