package com.application.service;

import com.application.validation.CustValidation;
import com.application.validation.TestValidation;
import org.springframework.stereotype.Service;

@Service
public class TestValidationService {


    @CustValidation
    public void doTestValidation(TestValidation testValidation){

    }
}
