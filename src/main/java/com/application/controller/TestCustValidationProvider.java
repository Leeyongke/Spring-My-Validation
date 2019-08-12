package com.application.controller;


import com.application.service.TestValidationService;
import com.application.validation.TestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCustValidationProvider {

    @Autowired
    TestValidationService testValidationService;


    @PostMapping(name = "insert one personal info",value = "/testValidation")
    public ResponseEntity<String> testValidation(@RequestBody TestValidation testValidation){
        testValidationService.doTestValidation(testValidation);
        return ResponseEntity.ok("ok");
    }
}
