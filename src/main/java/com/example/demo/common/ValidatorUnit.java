package com.example.demo.common;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ValidatorUnit {

    private static Validator validator=Validation.buildDefaultValidatorFactory().getValidator();


    public static <T> List<String> validate(T obj){

         Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);

         if(constraintViolations.size()==0){
             return null;
         }

        List<String> messages=new ArrayList<>();

         for (ConstraintViolation constraintViolation:constraintViolations){
             messages.add(String.format("%s",
                     constraintViolation.getMessage()));
         }

         return messages;
    }

}
