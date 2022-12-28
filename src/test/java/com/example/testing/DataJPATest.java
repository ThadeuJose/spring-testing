package com.example.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.testing.model.Employee;
import com.example.testing.repository.EmployeeRepository;

@DataJpaTest
public class DataJPATest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void shouldReturnEmployee() {
        // given
        Employee alex = new Employee("Alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName("Alex");

        // then
        assertThat(found.getName()).isEqualTo(alex.getName());
    }
}
