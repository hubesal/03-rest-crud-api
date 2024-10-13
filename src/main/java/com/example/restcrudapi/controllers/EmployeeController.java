package com.example.restcrudapi.controllers;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.models.Employee;
import com.example.restcrudapi.repositories.employee.EmployeeRepository;
import com.example.restcrudapi.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/magic-api/members")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeController {

    private final EmployeeService employeeService;
    @GetMapping("/{id}")
    public EntityModel<Employee> getById(@PathVariable int id) {
        var employee = employeeService.find(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not found for id: " + id)
        );

        var result = EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).getById(id)).withSelfRel(),
                linkTo(EmployeeController.class).withRel("members"));

        return result;
    }

 }
