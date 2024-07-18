package com.codingShuttle.com.faizan.week2.springbootwebtutorial.controller;


import com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    //PathVariable
    //employee/123
    @GetMapping(path = "/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    //RequestParam
    // employee?id=123 //it is optional
    @GetMapping(path = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping(path = "/employees")
    public ResponseEntity<EmployeeDTO> crateNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return  ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeDTO));
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeById(@PathVariable Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
       if(gotDeleted) return ResponseEntity.ok(true);
       return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/employees/{employeeId}")
    public ResponseEntity<EmployeeDTO> partialUpdateOfEmployeeById(@RequestBody Map<String, Object> updates,
                                                   @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.partialUpdateOfEmployeeById(employeeId,updates);
        if (employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);

    }
}
