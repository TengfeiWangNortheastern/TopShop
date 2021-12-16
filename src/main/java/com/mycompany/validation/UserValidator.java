package com.mycompany.validation;

import com.mycompany.pojo.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Validation;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","empty-name","Name is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","empty-password","Password is empty");
//        User user=(User)o;
//        if(user.getName().contains("...")){
//            errors.rejectValue();
//        }
    }
}
