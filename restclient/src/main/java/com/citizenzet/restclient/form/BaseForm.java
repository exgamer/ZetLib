package com.citizenzet.restclient.form;

import android.databinding.BaseObservable;
import com.citizenzet.restclient.validator.BaseValidator;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseForm extends BaseObservable {

    private Map<String, String> errors = new HashMap<String, String>();

    public boolean validate() throws IllegalAccessException {
        clearErrors();
        Field[] fields = getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if (getRules().containsKey(fieldName)){
                Object value =fields[i].get(this);
                List<? extends BaseValidator> validators = getRules().get(fieldName);
                Iterator<? extends BaseValidator> iterator = validators.iterator();
                while (iterator.hasNext()) {
                    BaseValidator validator = iterator.next();
                    if (validator.validate(value) == false){
                        addError(fieldName, validator.getErrorMessage());
                    }
                }
            }
        }

        return isValid();
    }

    public boolean isValid(){
        if (getErrors().isEmpty()){
            return true;
        }

        return false;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void addError(String field, String msg){
        errors.put(field, msg);
    }

    public void clearErrors(){
        errors = new HashMap<String, String>();
    }

    public Map<String, List<? extends BaseValidator>> getRules(){
        return new HashMap<String, List<? extends BaseValidator>>();
    }
}
