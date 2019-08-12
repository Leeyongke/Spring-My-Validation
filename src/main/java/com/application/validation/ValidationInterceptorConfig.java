package com.application.validation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *校验拦截器
 */
@Configuration
@EnableAspectJAutoProxy
@Aspect
public class ValidationInterceptorConfig {

    @Pointcut(  "@annotation(CustValidation)")
    public void validation() {
    }


    @Bean
    public Advisor validationAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        pointcut.setExpression("com.application.validation.ValidationInterceptorConfig.validation()");
        return new DefaultPointcutAdvisor(pointcut, new ValidationMethodInterceptor());
    }
}
