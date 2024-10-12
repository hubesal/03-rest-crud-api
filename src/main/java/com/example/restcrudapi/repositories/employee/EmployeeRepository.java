package com.example.restcrudapi.repositories.employee;

import com.example.restcrudapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
