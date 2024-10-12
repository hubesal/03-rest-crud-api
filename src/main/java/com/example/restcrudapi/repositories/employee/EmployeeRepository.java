package com.example.restcrudapi.repositories.employee;

import com.example.restcrudapi.models.Employee;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeRepository implements EmployeeDao {
    private final EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        var query = entityManager.createQuery("from Employee", Employee.class);
        var employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {
        var employee = entityManager.find(Employee.class, id);
        if (employee == null) {
            System.out.println("No employee found with id " + id);
            return;
        }

        entityManager.remove(employee);
    }
}
