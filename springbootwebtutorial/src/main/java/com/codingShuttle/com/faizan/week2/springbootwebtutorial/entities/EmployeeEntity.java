package com.codingShuttle.com.faizan.week2.springbootwebtutorial.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

//What entity will do that this is the java class which you need to convert into table inside the database
//Hibernate will do that
@Entity
@Table(name = "employees") //for the table name
public class EmployeeEntity {
    //Id is used for the PK || generated value for the autoincrement
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}