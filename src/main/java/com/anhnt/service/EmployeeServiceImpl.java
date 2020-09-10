package com.anhnt.service;

import com.anhnt.entity.EmployeeEntity;
import com.anhnt.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<List<EmployeeEntity>> findAllEmployees(String name, Pageable pageable) {
        return employeeRepo.findAllByName(name, pageable);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    public void handlerData() {

    }
}
