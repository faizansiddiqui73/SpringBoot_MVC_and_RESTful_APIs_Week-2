package com.codingShuttle.com.faizan.week2.springbootwebtutorial.controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age) {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/employees")
    public EmployeeDTO crateNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        inputEmployee.setId(100L);
        return employeeService.createNewEmployee(employeeDTO);
    }

    @PutMapping(path = "/employees/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public boolean deleteEmployeById(@PathVariable Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/employees/{employeeId}")
    public EmployeeDTO partialUpdateOfEmployeeById(@RequestBody Map<String, Object> updates,
                                                   @PathVariable Long employeeId) {
        return employeeService.partialUpdateOfEmployeeById(updates,employeeId);

    }
}
