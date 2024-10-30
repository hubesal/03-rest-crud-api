package com.example.restcrudapi.validators;

import com.example.restcrudapi.repositories.employee.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank()) {
            return true; // Let other annotations like @NotBlank handle null/empty cases
        }
        var isUniqueEmail = employeeRepository.existsByEmail(email);

        return isUniqueEmail;
    }
}