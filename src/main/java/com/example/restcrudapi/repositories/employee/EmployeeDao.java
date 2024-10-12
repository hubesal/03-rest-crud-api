package com.example.restcrudapi.repositories.employee;

import com.example.restcrudapi.models.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee find(int id);
    Employee save(Employee employee);
    void delete(int id);
}
