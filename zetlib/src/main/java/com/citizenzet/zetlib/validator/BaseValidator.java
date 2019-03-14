package com.citizenzet.zetlib.validator;

public abstract class BaseValidator<V> {

    public abstract boolean validate(V value);

    public abstract String getErrorMessage();
}
