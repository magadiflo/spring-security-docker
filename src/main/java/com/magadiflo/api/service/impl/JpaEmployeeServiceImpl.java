package com.magadiflo.api.service.impl;

import com.magadiflo.api.model.Employee;
import com.magadiflo.api.repository.IJpaEmployeeRepository;
import com.magadiflo.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "jpaEmployeeServiceImpl")
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
