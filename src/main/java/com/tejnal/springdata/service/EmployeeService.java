package com.tejnal.springdata.service;

import com.tejnal.springdata.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    Optional<Employee> findById(long employeeId);
    void delete(Employee employee);

}
