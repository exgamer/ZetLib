package com.citizenzet.zetlib.validator;

public class EmptyIntValidator extends BaseValidator<Integer> {
    @Override
    public boolean validate(Integer value) {
        if (value == null) {
            return false;
        }

        return true;
    }
}
