package com.citizenzet.zetlib.validator;

public class EmailValidator extends BaseValidator<String>{
    @Override
    public boolean validate(String value) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }
}
