package com.citizenzet.restclient.form;

import android.databinding.BaseObservable;
import java.util.ArrayList;
import java.util.List;

public class BaseForm extends BaseObservable {
    private List<String> errors = new ArrayList<String>();

    public boolean validate(){
        return true;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String msg){
        errors.add(msg);
    }

    public void clearErrors(){
        errors = new ArrayList<String>();
    }
}
