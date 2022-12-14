package com.magadiflo.api.repository;

import com.magadiflo.api.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryEmployeeRepository {

    private static final List<Employee> DATA_BASE = new ArrayList<>();

    static {
        DATA_BASE.add(new Employee(1, "Liz", "Gonzales", "liz@gmail.com"));
        DATA_BASE.add(new Employee(2, "Karen", "Caldas", "karen@gmail.com"));
        DATA_BASE.add(new Employee(3, "Yumixsa", "Ramos", "yumixsa@gmail.com"));
    }

    private static int getMaxId() {
        return DATA_BASE.stream().mapToInt(Employee::getId).max().orElseThrow();
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(getMaxId() + 1);
        DATA_BASE.add(employee);
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(DATA_BASE);
    }

    public Employee findById(Integer id) {
        return DATA_BASE.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseThrow();
    }

    public Employee updateEmployee(Employee employee) {
        int indexOfElement = IntStream.range(0, DATA_BASE.size())
                .filter(index -> DATA_BASE.get(index).getId().equals(employee.getId()))
                .findFirst().orElseThrow();
        DATA_BASE.set(indexOfElement, employee);
        return DATA_BASE.get(indexOfElement);
    }

    public Boolean deleteById(Integer id) {
        Employee employee = DATA_BASE.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElseThrow();
        return DATA_BASE.remove(employee);
    }

}
