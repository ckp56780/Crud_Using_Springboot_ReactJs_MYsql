package com.CrudUsingSpringBoot.React.repository;

import com.CrudUsingSpringBoot.React.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //it will give all inbuilt method to perform all database operation like CRUD-OPERATION

}
