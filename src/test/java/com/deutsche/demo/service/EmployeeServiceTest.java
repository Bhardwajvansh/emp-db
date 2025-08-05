package com.deutsche.demo.service;

import com.deutsche.demo.model.Employee;
import com.deutsche.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    private EmployeeRepository employeeRepository;

    EmployeeRepository mockRepo = Mockito.mock(EmployeeRepository.class);

    @Test
    void test(){
        EmployeeService employeeService = new EmployeeService();
        List<Employee> emplist = employeeService.getAllEmployees();
        assertEquals(7, emplist.size());
    }
}
