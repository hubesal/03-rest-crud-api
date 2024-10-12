package com.example.restcrudapi.services.employee;

import com.example.restcrudapi.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> find(int id);

    Employee save(Employee employee);

    void delete(int id);
}
