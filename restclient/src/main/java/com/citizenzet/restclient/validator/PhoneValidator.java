package com.citizenzet.restclient.validator;

import android.content.res.Resources;

import com.citizenzet.restclient.R;

public class PhoneValidator extends BaseValidator<String>{
    @Override
    public boolean validate(String value) {
        return android.util.Patterns.PHONE.matcher(value).matches();
    }

    @Override
    public String getErrorMessage() {
        return Resources.getSystem().getString(R.string.phone_error);
    }
}