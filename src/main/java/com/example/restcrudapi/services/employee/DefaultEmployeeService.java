package com.example.restcrudapi.services.employee;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.models.Employee;
import com.example.restcrudapi.repositories.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultEmployeeService implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> find(int id) {

        return employeeRepository.findById(id);
    };
    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
