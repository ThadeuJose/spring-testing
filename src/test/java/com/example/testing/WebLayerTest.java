package com.example.testing;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.testing.controller.EmployeeController;
import com.example.testing.model.Employee;
import com.example.testing.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void shouldnReturnJsonArray() throws Exception {

        when(service.getAllEmployees()).thenReturn(Arrays.asList(new Employee("alex")));

            
        mvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("alex")));
    }
}
