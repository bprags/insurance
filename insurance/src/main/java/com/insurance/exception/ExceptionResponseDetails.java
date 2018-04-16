package com.insurance.exception;

/**
 * Created by Gokul-Namit on 13-04-2018.
 */
public class ExceptionResponseDetails {

    private String description;

    public ExceptionResponseDetails(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
