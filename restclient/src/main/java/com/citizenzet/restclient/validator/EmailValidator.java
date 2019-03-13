package com.citizenzet.restclient.validator;

import android.content.res.Resources;

import com.citizenzet.restclient.R;

public class EmailValidator extends BaseValidator<String>{
    @Override
    public boolean validate(String value) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return Resources.getSystem().getString(R.string.email_error);
    }
}
