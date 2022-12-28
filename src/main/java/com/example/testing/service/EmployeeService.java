package com.example.testing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testing.model.Employee;

@Service
public class EmployeeService {

    public List<Employee> getAllEmployees() {
        new Exception("Should not be call");
        return null;
    }

}
