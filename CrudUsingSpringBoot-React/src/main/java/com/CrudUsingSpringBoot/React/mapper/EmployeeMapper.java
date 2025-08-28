package com.CrudUsingSpringBoot.React.mapper;

import com.CrudUsingSpringBoot.React.dto.EmployeeDto;
import com.CrudUsingSpringBoot.React.entity.Employee;

public class EmployeeMapper {

    //employee mapper class
    //2.employee to Employee_Dto--employeeDto return hoga
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //1.employee_Dto to employee  --employee return hoga

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
