package com.citizenzet.zetlib.validator;

public abstract class BaseValidator<V> {
    private String errorMessage = "error";

    public abstract boolean validate(V value);

    public String getErrorMessage(){
        return errorMessage;
    }

    public BaseValidator setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;

        return this;
    }
}
