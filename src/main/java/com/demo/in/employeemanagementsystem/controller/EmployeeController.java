package com.demo.in.employeemanagementsystem.controller;

import com.demo.in.employeemanagementsystem.model.Employee;
import com.demo.in.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /*
        URL : http://localhost:8080/employee/saveEmployee
        Input :
               {
                 "ename": "Raj Prudhvi",
                 "ecity":"Hyderabad",
                 "email":"raj@gmail.com",
                 "egender":"MALE"
               }
     */
    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/{eid}")
    public ResponseEntity<Employee> saveEmployee(@PathVariable Integer eid){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(eid), HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmployee/{eid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eid, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateOrSaveEmployee(eid,employee),HttpStatus.OK);
    }

}
