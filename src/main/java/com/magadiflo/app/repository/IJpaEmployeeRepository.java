package com.magadiflo.app.repository;

import com.magadiflo.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository, aquí sería opcional esta anotación, ya que al estar extendiendo de JpaRepository, Spring se encargará de manejarlo
@Repository
public interface IJpaEmployeeRepository extends JpaRepository<Employee, Integer> {

}
