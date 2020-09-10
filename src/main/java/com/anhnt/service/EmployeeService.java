package com.anhnt.service;

import com.anhnt.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAll();
    Page<List<EmployeeEntity>> findAllEmployees(String name, Pageable pageable);
    EmployeeEntity updateEmployee (EmployeeEntity employeeEntity);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
}
