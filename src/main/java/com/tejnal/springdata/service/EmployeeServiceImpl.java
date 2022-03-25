package com.tejnal.springdata.service;

import com.tejnal.springdata.domain.entity.Employee;
import com.tejnal.springdata.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee save(Employee employee) {
   return  employeeRepository.save(employee);
  }

  @Override
  public List<Employee> findAll() {
   return  employeeRepository.findAll();
  }

  @Override
  public Optional<Employee> findById(long employeeId) {
    return employeeRepository.findById(Math.toIntExact(employeeId));
  }

  @Override
  public void delete(Employee employee) {

  }


}
