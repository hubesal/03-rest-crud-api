package com.example.restcrudapi.controllers;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.models.Employee;
import com.example.restcrudapi.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magic-api/members")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        var employee = employeeService.find(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found for id: " + id)
        );

        return employee;
    }

 }
