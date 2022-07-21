package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmpById(Integer id) {
        Optional<Employee>  temp = this.employeeRepository.findById(id);
        Employee emp  = null ;
        if(temp.isPresent()){
            emp = temp.get();
        }
        else {
            throw new RuntimeException("Employee does not exist");
        }
        return emp;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
