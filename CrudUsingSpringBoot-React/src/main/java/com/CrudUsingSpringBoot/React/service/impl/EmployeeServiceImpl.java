package com.CrudUsingSpringBoot.React.service.impl;


import com.CrudUsingSpringBoot.React.dto.EmployeeDto;
import com.CrudUsingSpringBoot.React.entity.Employee;
import com.CrudUsingSpringBoot.React.exception.ResourceNotFoundException;
import com.CrudUsingSpringBoot.React.mapper.EmployeeMapper;
import com.CrudUsingSpringBoot.React.repository.EmployeeRepository;
import com.CrudUsingSpringBoot.React.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //use dependency
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);//converting into employee
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); //again converted to employeeDto because return type is dto
    }


    //implementation of get employee by id
    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee with gevn id is not found" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> listOfEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("employee with given id is not found"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    //delete employeeBy Id
    @Override
    public void deleteById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("employee with given id is not found" + employeeId));
        employeeRepository.deleteById(employeeId);
    }




}
