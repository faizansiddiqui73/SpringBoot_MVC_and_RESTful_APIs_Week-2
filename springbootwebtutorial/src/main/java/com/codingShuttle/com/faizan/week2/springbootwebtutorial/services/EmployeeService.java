package com.codingShuttle.com.faizan.week2.springbootwebtutorial.services;

import com.codingShuttle.com.faizan.week2.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.codingShuttle.com.faizan.week2.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));
//        return  employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1,EmployeeDTO.class));
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
        return modelMapper.map(employeeEntity, EmployeeDTO.class); //converted back to DTO
    }
    public boolean isExistsEmployeeById(Long employeeId){
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) throw new ResourceNotFoundException("Employee Not Found: " + employeeId);
        return true;
    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        //find
       isExistsEmployeeById(employeeId);
        EmployeeEntity conversionToEnity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        conversionToEnity.setId(employeeId);
        EmployeeEntity toSaveEntity = employeeRepository.save(conversionToEnity); //entity to class
        return modelMapper.map(toSaveEntity, EmployeeDTO.class);
    }



    public boolean deleteEmployeeById(Long employeeId) {
       isExistsEmployeeById(employeeId);
       employeeRepository.deleteById(employeeId);
       return true;
    }

    public EmployeeDTO partialUpdateOfEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExistsEmployeeById(employeeId);
        //FindById
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field,value)-> {
          Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field); //is used to find the Field object corresponding to the field name in the EmployeeEntity class.
          fieldToBeUpdated.setAccessible(true); //make it accessible
          ReflectionUtils.setField(fieldToBeUpdated,employeeEntity ,value); // sets the new value to the field in the employeeEntity object.
        });
        EmployeeEntity toSaveEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(toSaveEntity,EmployeeDTO.class);
    }
}
