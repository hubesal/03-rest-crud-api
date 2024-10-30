package com.example.restcrudapi.services.employee;

import com.example.restcrudapi.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> find(int id);

    void delete(int id);

    boolean exists(String email);
}
