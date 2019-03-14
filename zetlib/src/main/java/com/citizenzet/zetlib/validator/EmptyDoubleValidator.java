package com.citizenzet.zetlib.validator;

public class EmptyDoubleValidator extends BaseValidator<Double> {
    @Override
    public boolean validate(Double value) {
        if (value == null) {
            return false;
        }

        return true;
    }
}
