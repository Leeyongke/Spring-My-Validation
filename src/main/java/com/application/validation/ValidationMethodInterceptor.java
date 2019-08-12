package com.application.validation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ValidationMethodInterceptor  implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        for(Object inputObject:invocation.getArguments()){
            ValidationUtil.validationNotEmptyForObject(inputObject);

        }
        return invocation.proceed();
    }
}
