package com.oocl.company.controllers;


import com.oocl.company.entities.Company;
import com.oocl.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private CompanyRepository repositories;

    @Autowired
    public CompanyController(CompanyRepository repositories){
        this.repositories = repositories;
    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        return repositories.save(company);
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getAllCompany(){
        return repositories.findAll();
    }
}
