package com.magadiflo.app.service.impl;

import com.magadiflo.app.model.Employee;
import com.magadiflo.app.repository.IJpaEmployeeRepository;
import com.magadiflo.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final IJpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.jpaEmployeeRepository.save(employee); //Debe venir con el id == null
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return this.jpaEmployeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.jpaEmployeeRepository.save(employee); //Debe venir con el id != null
    }

    @Override
    public Boolean deleteById(Integer id) {
        this.jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
