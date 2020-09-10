package com.anhnt.controller;

import com.anhnt.entity.EmployeeEntity;
import com.anhnt.repository.EmployeeRepo;
import com.anhnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/addemployee")
    public String openAddEmployee(Model model) {
        EmployeeEntity employee = new EmployeeEntity();
        model.addAttribute("employee", employee);
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String createEmployee(@ModelAttribute EmployeeEntity employee) {
        employeeService.saveEmployee(employee);
        return "listemployee";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(id);

        model.addAttribute("employees", employeeEntity);
        return "updateemployee";
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@RequestBody EmployeeEntity employeeEntity, Model model) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepo.findById(employeeEntity.getId());
        if (optionalEmployeeEntity.isPresent()) {
            EmployeeEntity existEmployee = optionalEmployeeEntity.get();
            existEmployee.setName(employeeEntity.getName());
            existEmployee.setId(employeeEntity.getId());
            existEmployee.setSalary(employeeEntity.getSalary());
            employeeRepo.save(existEmployee);
        }
        employeeService.updateEmployee(employeeEntity);
        model.addAttribute("employees", employeeRepo.findAll());
        return "redirect:/listemployee";
    }

    @GetMapping({"/listemployee", "/"})
    public String findAllEmployees(Model model) {
        List<EmployeeEntity> list = employeeService.getAll();
        model.addAttribute("employees", list);
        return "listemployee";
    }
}
