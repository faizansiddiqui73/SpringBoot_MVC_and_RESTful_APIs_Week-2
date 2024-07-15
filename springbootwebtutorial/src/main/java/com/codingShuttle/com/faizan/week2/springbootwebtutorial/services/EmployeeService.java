package com.codingShuttle.com.faizan.week2.springbootwebtutorial.services;

import com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    //whatever needed most create a bean of it and inject it.

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        //giving the DTO 1// covert the dto in entity coz the employeeRepository only save the entity
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class); //coverts to DTO to entity
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        //find
        EmployeeEntity conversionToEnity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        conversionToEnity.setId(employeeId);
        EmployeeEntity toSaveEntity = employeeRepository.save(conversionToEnity); //entity to class
        return modelMapper.map(toSaveEntity, EmployeeDTO.class);
    }


    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            return false;
        } else {
            employeeRepository.deleteById(employeeId);
            return false;
        }

    }
}
