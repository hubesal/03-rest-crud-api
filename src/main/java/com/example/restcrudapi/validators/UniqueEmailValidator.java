package com.example.restcrudapi.validators;

import com.example.restcrudapi.repositories.employee.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private EmployeeRepository employeeRepository;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
        this.employeeRepository = (EmployeeRepository) ContextProvider.getBean(EmployeeRepository.class);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank()) {
            return true; // Let other annotations like @NotBlank handle null/empty cases
        }
        var isUniqueEmail = employeeRepository.findByEmail(email).isEmpty();

        return isUniqueEmail;
    }
}