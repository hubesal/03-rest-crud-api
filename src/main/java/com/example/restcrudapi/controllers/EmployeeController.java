package com.example.restcrudapi.controllers;

import com.example.restcrudapi.exceptions.EmployeeNotFoundException;
import com.example.restcrudapi.models.Employee;
import com.example.restcrudapi.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/magic-api/members")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/exists")
    public boolean exists(@RequestParam String email) {
        var result = employeeService.exists(email);

        return result;
    }
 }
