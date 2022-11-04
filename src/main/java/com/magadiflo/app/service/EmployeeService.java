package com.magadiflo.app.service;

import com.magadiflo.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    // Save an employee
    void addEmployee(Employee employee);

    // Get employees
    List<Employee> getAllEmployees();

    // Get one employee
    Employee findById(Integer id);

    // Update employee
    void updateEmployee(Employee employee);

    // Delete employee
    Boolean deleteById(Integer id);
}
