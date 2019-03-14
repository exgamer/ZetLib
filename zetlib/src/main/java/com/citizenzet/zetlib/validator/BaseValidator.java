package com.citizenzet.zetlib.validator;

import android.content.res.Resources;

public abstract class BaseValidator<V> {
    private String errorMessage = "error";

    public abstract boolean validate(V value);

    public String getErrorMessage(){
        return errorMessage;
    }

    public BaseValidator setErrorMessage(int stringId){
        errorMessage = Resources.getSystem().getString(stringId);

        return this;
    }
}
