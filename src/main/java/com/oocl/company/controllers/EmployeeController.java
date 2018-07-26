package com.oocl.company.controllers;

import com.oocl.company.controllers.DTO.EmployeeDTO;
import com.oocl.company.entities.Employee;
import com.oocl.company.repositories.CompanyRepository;
import com.oocl.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    public EmployeeController(EmployeeRepository _employeeRepository){
        employeeRepository = _employeeRepository;
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeDTO> employees = new ArrayList<>();
//        List<Employee> employees = employeeRepository.findAll();
        employeeRepository.findAll().stream().forEach(employee -> employees.add(new EmployeeDTO(employee)));
        return employees;
    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

}
