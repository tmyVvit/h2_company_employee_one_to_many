package com.oocl.company.controllers;


import com.oocl.company.entities.Company;
import com.oocl.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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

    @Transactional
    @GetMapping(path = "/{companyID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getAllCompany(@PathVariable Long companyID){
        return repositories.findById(companyID).get();
    }

    @Transactional
    @PutMapping(path = "/{companyID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCompanyById(@RequestBody Company company){
        repositories.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @DeleteMapping(path = "/{companyID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company deleteCompanyById(@PathVariable Long companyID){
        Company company = repositories.findById(companyID).get();
        repositories.delete(company);
        return company;
    }


}
