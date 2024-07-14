package com.codingShuttle.com.faizan.week2.springbootwebtutorial.Controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmpolyeeController {

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
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"faizan","faizansiddiqui73@gmail.com",24, LocalDate.of(2024,07,14),true);
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public String getAllEmployees(@RequestParam(required = false) Integer age){
        return "Hi my "+age;
    }
}
