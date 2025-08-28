package com.CrudUsingSpringBoot.React.controller;

import com.CrudUsingSpringBoot.React.dto.EmployeeDto;
import com.CrudUsingSpringBoot.React.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    //use dependency
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);

        //@RequestBody this annotation is basically used for the convert json to java object
    }

    //get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto1 = employeeService.getEmployeeById(employeeId);
        return  ResponseEntity.ok(employeeDto1);

        //@RequestBody this annotation is basically used for the convert json to java object
    }

    //list of employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getListOfEmployee(){
        List<EmployeeDto> employeeDtos = employeeService.listOfEmployee();
        return ResponseEntity.ok(employeeDtos);
    }

    //update employee by id
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeBYId(@PathVariable("id")  Long employeeId ,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //delete employee by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeBYId(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
        return ResponseEntity.ok("deleted!!");


    }

}

