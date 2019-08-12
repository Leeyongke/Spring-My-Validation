package com.application.validation;

import lombok.Data;

@Data
public class TestValidation {

    @NotEmpty
    private String name;

    private  String additionalName;
}
