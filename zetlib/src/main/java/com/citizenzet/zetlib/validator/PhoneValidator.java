package com.citizenzet.zetlib.validator;

public class PhoneValidator extends BaseValidator<String>{
    @Override
    public boolean validate(String value) {
        return android.util.Patterns.PHONE.matcher(value).matches();
    }
}