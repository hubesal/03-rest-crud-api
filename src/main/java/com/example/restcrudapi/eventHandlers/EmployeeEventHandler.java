package com.example.restcrudapi.eventHandlers;

import com.example.restcrudapi.models.Employee;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class EmployeeEventHandler {
    @HandleBeforeCreate
    public void handleEmployeeBeforeCreate(Employee employee) {
        System.out.println("Creating employee...");
    }

    @HandleAfterCreate
    public void handleEmployeeAfterCreate(Employee employee) {
        System.out.println("Employee created with id: " + employee.getId());
    }
}
