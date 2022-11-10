package com.magadiflo.api.resource;

import com.magadiflo.api.model.Employee;
import com.magadiflo.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "jpaEmployeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(this.employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = this.employeeService.addEmployee(employee);
        return ResponseEntity.created(this.getLocation(emp.getId())).body(emp);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        employee.setId(id);
        return ResponseEntity.ok(this.employeeService.updateEmployee(employee));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(this.employeeService.deleteById(id));
    }

}
