package com.citizenzet.zetlib.form;

import android.databinding.BaseObservable;
import android.util.Log;
import com.citizenzet.zetlib.validator.BaseValidator;
import org.apache.commons.lang3.reflect.FieldUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseForm extends BaseObservable {

    private Map<String, String> errors = new HashMap<String, String>();
    private Map<String, List<? extends BaseValidator>> rules = new HashMap<String, List<? extends BaseValidator>>();

    public boolean validate() {
        clearErrors();
        rules = new HashMap<String, List<? extends BaseValidator>>();
        rules();
        Field[] fields = getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if (getRules().containsKey(fieldName)){
                Object value = null;
                try {
                    value = FieldUtils.readField(fields[i], this, true);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                List<? extends BaseValidator> validators = getRules().get(fieldName);
                Iterator<? extends BaseValidator> iterator = validators.iterator();
                while (iterator.hasNext()) {
                    BaseValidator validator = iterator.next();
                    if (validator.validate(value) == false){
                        addError(fieldName, validator.getErrorMessage());
                        break;
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

    public <T extends BaseValidator> void  addRules(String field, List<T> validators ){
        rules.put(field, validators);
    }

    public Map<String, List<? extends BaseValidator>> getRules(){
        return rules;
    }

    /**
     * Метод для задания правил валидации полей формы
     */
    public void rules(){}
}
