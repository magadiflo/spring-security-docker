package com.magadiflo.app.service.impl;

import com.magadiflo.app.model.Employee;
import com.magadiflo.app.repository.InMemoryEmployeeRepository;
import com.magadiflo.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.inMemoryEmployeeRepository.getAllEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return this.inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.inMemoryEmployeeRepository.deleteById(id);
    }

}
