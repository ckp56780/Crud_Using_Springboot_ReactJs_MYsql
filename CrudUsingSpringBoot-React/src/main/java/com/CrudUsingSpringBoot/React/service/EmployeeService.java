package com.CrudUsingSpringBoot.React.service;

import com.CrudUsingSpringBoot.React.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //get employee by id
    EmployeeDto getEmployeeById(Long employeeId);

    //get List of employee
    List<EmployeeDto> listOfEmployee();

    //update employee
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    //delete employee by id;
    void deleteById(Long employeeId);
}
