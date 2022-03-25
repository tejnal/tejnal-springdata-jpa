package com.tejnal.springdata.controller;

import com.tejnal.springdata.domain.entity.Employee;
import com.tejnal.springdata.exception.ResourceNotFoundException;
import com.tejnal.springdata.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired private EmployeeServiceImpl employeeServiceImpl;

  @PostMapping("/employee")
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeServiceImpl.save(employee);
  }

  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> addEmployee() {
    return ResponseEntity.ok(employeeServiceImpl.findAll());
  }

  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee> findEmployeeById(@PathVariable(value = "id") Integer employeeId) {
    Employee employee =
        employeeServiceImpl
            .findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found" + employeeId));

    return ResponseEntity.ok().body(employee);
  }

  @PutMapping
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable(value = "employeeId") Integer employeeId,
      @RequestBody Employee employeeDetails) {

    Employee employee =
        employeeServiceImpl
            .findById(employeeId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException(
                        "Employee not found for this id : " + employeeId));

    employee.setName(employeeDetails.getName());
    final Employee updateEmployee = employeeServiceImpl.save(employee);

    return ResponseEntity.ok(updateEmployee);
  }

  @DeleteMapping("employees/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") Integer employeeId) {
    Employee employee =
        employeeServiceImpl
            .findById(employeeId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found" + employeeId));
    employeeServiceImpl.delete(employee);
    return ResponseEntity.ok().build();
  }
}
