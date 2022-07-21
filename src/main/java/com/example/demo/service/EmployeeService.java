package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    Employee getEmpById(Integer id);
    public void deleteEmployeeById(Integer id);
}
