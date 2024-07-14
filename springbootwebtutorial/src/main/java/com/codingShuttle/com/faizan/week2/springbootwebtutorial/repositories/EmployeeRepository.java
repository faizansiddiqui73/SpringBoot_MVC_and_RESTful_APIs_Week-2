package com.codingShuttle.com.faizan.week2.springbootwebtutorial.repositories;

import com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //will grab the methods to play around the data
}
