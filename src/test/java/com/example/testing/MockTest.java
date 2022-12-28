package com.example.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testing.repository.HelloRepository;
import com.example.testing.service.HelloService;

@SpringBootTest
public class MockTest {
    @Mock
    private HelloRepository helloRepository;

    private HelloService helloService;

    @BeforeEach
    void setMockOutput() {
        helloService = new HelloService(helloRepository);
        when(helloRepository.get()).thenReturn("Hello Mockito From Repository");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Repository", helloService.get());
    }

}
