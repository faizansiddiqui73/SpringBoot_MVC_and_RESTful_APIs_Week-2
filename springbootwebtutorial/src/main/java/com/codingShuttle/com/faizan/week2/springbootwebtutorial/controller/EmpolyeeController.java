package com.codingShuttle.com.faizan.week2.springbootwebtutorial.controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.repositories.EmployeeRepository;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpolyeeController {

    //2.4 Injecting the DI via Service layer
    //Constructor Injection
    private EmployeeService employeeService;

    public EmpolyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String getServer() {
        return "Hello from spring sever";
    }

    String msg = "Honey";

    @GetMapping(path = "/getSecretMessage")
    public String getMySecretMessage() {
        return "Here is my seceret message : " + msg;
    }

    //PathVariable
    //employee/123
    @GetMapping(path = "/employees/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age) {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/employees")
    public EmployeeEntity crateNewEmployee(@RequestBody EmployeeEntity inputEmployee) {
//        inputEmployee.setId(100L);
        return employeeService.createNewEmployee(inputEmployee);
    }
}
