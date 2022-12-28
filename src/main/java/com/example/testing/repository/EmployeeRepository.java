package com.example.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testing.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);

}