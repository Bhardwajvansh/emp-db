package com.deutsche.demo.controller;

import com.deutsche.demo.model.Employee;
import com.deutsche.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// methods in this class should not return raw business objects
// they should return ResponseEntity objects
// refactor the code accordingly
// LOG as applicable
// access ui here -
//http://localhost:8090/api/v1/swagger-ui/index.html

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    //    http://localhost:8090/api/v1/employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    //    http://localhost:8090/api/v1/employees/101
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
//        return employeeService.getEmployeeById(id);
//    }

    //    http://localhost:8090/api/v1/employees/101
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .header("message", "Employee with the id " + id + " fetched successfully.")
                .body(employeeService.getEmployeeById(id));
    }

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

//    //    http://localhost:8090/api/v1/employees/101
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Integer id) {
//        Employee employee =  employeeService.getEmployeeById(id);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("message", "Employee with the id " + id + " returned successfully.");
//        HttpStatus status = HttpStatus.OK;
//        ResponseEntity<Employee> response = new ResponseEntity<>(employee, headers, status);
//        return response;
//    }


    //    http://localhost:8090/api/v1/employees
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    //    http://localhost:8090/api/v1/employees
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    //    http://localhost:8090/api/v1/employees/101
    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@PathVariable(name = "id") Integer id) {

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }
//
//    @GetMapping("/salary/{salary}")
//    public List<Employee> getEmployeeBySalary(@PathVariable Double salary) {
//        return employeeService.getEmployeeBySalary(salary);
        //    }
}


//package com.deutsche.demo.controller;
//
//import com.deutsche.demo.model.Employee;
//import com.deutsche.demo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api")
//public class EmployeeController {
//
/// /    private EmployeeService empService = new EmployeeService();
//
//    @Autowired
//    private EmployeeService empService;
//
//    //    http://localhost:8080/api/emp
//    @GetMapping("emp")
//    public List<Employee> getAllEmployees() {
//        return empService.getAllEmployees();
//    }
//
//    //    http://localhost:8080/api/emp/101
//    @GetMapping("emp/{id}")
//    public Employee getEmployeeById(@PathVariable( name = "id") Integer id) {
//        return empService.getEmployeeById(id);
//    }
//
//    //    http://localhost:8080/api/emp
//    @PostMapping("emp")
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return empService.addEmployee(employee);
//    }
//
/// /    public Object addEmployee() {
/// /        return null;
/// /    }
/// /
/// /    public Object updateEmployee() {
/// /        return null;
/// /    }
/// /
/// /    public Object deleteEmployee() {
/// /        return null;
/// /    }
//
//}
