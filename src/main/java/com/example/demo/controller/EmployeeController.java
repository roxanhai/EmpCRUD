package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public String viewHomePage(Model model){
        model.addAttribute("listEmp",this.employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/add_emp_form")
    public String showAddEmployeeForm(Model model){

        //Create Model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save Employee to Database
        this.employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/update_emp_form/{id}")
    public String showEditEmployeeForm(@PathVariable(value="id") Integer id,Model model){
        //Get require Employee from Service
        Employee employee = this.employeeService.getEmpById(id);
        model.addAttribute("employee",employee);
        return "/edit_employee";
    }

    @GetMapping("/delete_emp/{id}")
    public String deleteEmployee(@PathVariable(value="id") Integer id){
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

//    @PutMapping("/saveEditEmployee")
//    public String saveEditEmployee(@ModelAttribute("employee")Employee employee){
//        this.employeeService.saveEmployee(employee);
//        return "redirect:/";
//    }

}
