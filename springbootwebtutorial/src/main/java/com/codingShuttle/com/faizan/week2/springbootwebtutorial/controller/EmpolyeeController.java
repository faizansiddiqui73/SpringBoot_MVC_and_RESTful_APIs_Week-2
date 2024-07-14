package com.codingShuttle.com.faizan.week2.springbootwebtutorial.controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpolyeeController {

    //2.3 Injectiong the DI
    //Filed injection
    private EmployeeRepository employeeRepository;

    public EmpolyeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
//        return new EmployeeDTO(employeeId,"faizan","faizansiddiqui73@gmail.com",24, LocalDate.of(2024,07,14),true);
        return (EmployeeEntity) employeeRepository.findById(id).orElse(null);
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age) {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/employees")
    public EmployeeEntity crateNewEmployee(@RequestBody EmployeeEntity inputEmployee) {
//        inputEmployee.setId(100L);
        return employeeRepository.save(inputEmployee);
    }
}
