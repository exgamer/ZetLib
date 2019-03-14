package com.citizenzet.zetlib.validator;

import android.text.TextUtils;

public class EmptyStringValidator extends BaseValidator<String>{
    @Override
    public boolean validate(String value) {
        if (TextUtils.isEmpty(value)) {
            return false;
        }

        return true;
    }
}
