package com.ckr.springbootjpa;

import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(public * com.ckr.springbootjpa.AlienController.getAliens())")
    public void logBefore(){
        LOGGER.info("getAliens method has been called from aspect");
    }

    //the @After is final method so it will get executed even if the called method from client is successfully executed or even have exceptions or errors.
    //So we use AfterReturning logs the info only after successfull execution of requested method
    //and AfterThrowing helps in logging info when there is some exceptions.
    @AfterReturning("execution(public * com.ckr.springbootjpa.AlienController.getAliens())")
    public void logAfterReturning(){
        LOGGER.info("getAliens method got executed");
    }

    @AfterThrowing("execution(public * com.ckr.springbootjpa.AlienController.getAliens())")
    public void logAfterTrhowing(){
        LOGGER.info("there is an issue");
    }

//    @After("execution(public * com.ckr.springbootjpa.AlienController.getAliens())")
//    public void logAfter(){
//        LOGGER.info("getAliens method got executed");
//    }

}
