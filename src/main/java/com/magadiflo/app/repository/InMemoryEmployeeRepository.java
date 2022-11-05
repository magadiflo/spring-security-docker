package com.magadiflo.app.repository;

import com.magadiflo.app.model.Employee;
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

    public void addEmployee(Employee employee) {
        DATA_BASE.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return List.copyOf(DATA_BASE);
    }

    public Employee findById(Integer id) {
        return DATA_BASE.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElseThrow();
    }

    public void updateEmployee(Employee employee) {
        int indexOfElement = IntStream.range(0, DATA_BASE.size())
                .filter(index -> DATA_BASE.get(index).getId().equals(employee.getId()))
                .findFirst().orElseThrow();
        DATA_BASE.set(indexOfElement, employee);
    }

    public Boolean deleteById(Integer id) {
       Employee employee = DATA_BASE.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElseThrow();
       return DATA_BASE.remove(employee);
    }

}
