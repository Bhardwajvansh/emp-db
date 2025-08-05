package com.deutsche.demo.service;

import com.deutsche.demo.exception.EmployeeNotFoundException;
import com.deutsche.demo.model.Employee;
import com.deutsche.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Write business logic in this class
// getEmployeeById() - What if the employee does not exist?
// deleteEmployee() - What if the employee does not exist?
// addEmployee() - What if the employee already exists?
// etc

@Service
public class EmployeeService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        LOG.info("get all employees");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        LOG.info("Employee with the id " + id);
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent())
            return employeeOptional.get();
        else
            throw new EmployeeNotFoundException(id);
    }

    public List<Employee> getEmployeesByName(String name) {
        LOG.info("get employees by anme " + name);
        return employeeRepository.findByNameIgnoreCase(name);
    }

    public Employee addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee object must not be null");
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if (employee == null || employee.getId() == null) {
            throw new IllegalArgumentException("Employee or Employee ID must not be null");
        }
        Employee existingEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employee.getId()));
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    public Employee deleteEmployee(Integer id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        employeeRepository.deleteById(id);
        return existingEmployee;
    }


    public List<Employee> getEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found with name: " + name);
        }
        return employees;
    }
//
//    public List<Employee> getEmployeeBySalary(Double salary) {
//        List<Employee> employees = employeeRepository.findBySalary(salary);
//        if (employees.isEmpty()) {
//            throw new RuntimeException("No employees found with salary: " + salary);
//        }
//        return employees;
//    }
}


//package com.deutsche.demo.service;
//
//import com.deutsche.demo.model.Employee;
//import com.deutsche.demo.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    EmployeeRepository empRepository;
//
//    public List<Employee> getAllEmployees() {
//        return empRepository.findAll();
//    }
//
//    public Employee getEmployeeById(Integer id) {
//        return empRepository.findById(id).get();
//    }
//
//    public Employee addEmployee(Employee employee) {
//        return empRepository.save(employee);
//    }
//    public Employee updateEmployee(Employee employee) {
//        return empRepository.save(employee);
//    }
//    public Employee deleteEmployee(Integer id) {
//        empRepository.deleteById(id);
/// /        return the deleted employee object;
//        return null;
//    }
//}
//
//
/// /package com.deutsche.demo.service;
/// /
/// /import com.deutsche.demo.model.Employee;
/// /import com.deutsche.demo.repository.EmployeeRepository;
/// /import org.springframework.beans.factory.annotation.Autowired;
/// /import org.springframework.stereotype.Service;
/// /
/// /import java.util.ArrayList;
/// /import java.util.Arrays;
/// /import java.util.List;
/// /
/// /@Service
/// /public class EmployeeService {
/// /
/// /    private List<Employee> tempEmpList = new ArrayList<>(
/// /            Arrays.asList(
/// /                    new Employee(101, "Sonu", 90000.00),
/// /                    new Employee(101, "Sonu", 90000.00),
/// /                    new Employee(101, "Sonu", 90000.00)));
/// /
/// /    public List<Employee> getAllEmployees() {
/// /        System.out.println(tempEmpList.size());
/// /        return tempEmpList;
/// /    }
/// /
/// /    public Employee getEmployeeById(Integer id) {
/// /        System.out.println(id);
/// /        // write your logic
/// /        return tempEmpList.get(0);
/// /    }
/// /
/// /    public Employee addEmployee(Employee employee) {
/// /        System.out.println(employee.toString());
/// /        // write your logic
/// /        return employee;
/// /    }
/// /}
