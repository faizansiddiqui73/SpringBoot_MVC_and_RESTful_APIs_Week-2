package com.codingShuttle.com.faizan.week2.springbootwebtutorial.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MapperConfig {
    //bean creation as per our need
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//    ModelMapper is a Java library that helps in mapping objects from one model to another,
//    reducing the need for manual mapping code
}
