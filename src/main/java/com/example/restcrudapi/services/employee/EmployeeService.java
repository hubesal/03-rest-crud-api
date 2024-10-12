package com.example.restcrudapi.services.employee;

import com.example.restcrudapi.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee find(int id);

    Employee save(Employee employee);

    void delete(int id);
}
