package com.example.restcrudapi.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ShouldStartWithValidator implements ConstraintValidator<ShouldStartWith, String> {

    private String namePrefix;

    @Override
    public void initialize(ShouldStartWith constraintAnnotation) {
        namePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return name.startsWith(namePrefix);
    }
}
