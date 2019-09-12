package org.zoo.manager.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* org.zoo.manager.persistence.dao.*.*(..))")
    private void persistenceDaoMethods() {
    }

    @Pointcut("execution(* org.zoo.manager.persistence.service.*.*(..))")
    private void persistenceServiceMethods() {
    }

    @Pointcut("execution(* org.zoo.manager.controller.*.*(..))")
    private void controllerMethods() {
    }

    @Pointcut("persistenceDaoMethods() || persistenceServiceMethods() || controllerMethods()")
    private void allAuditedMethods() {
    }


    @Before("allAuditedMethods()")
    private void beforeLogging(JoinPoint point){
        logger.info("AUDITING::: " + point.getSignature().toShortString() + " is being called -> with args: ");
        for(Object o : point.getArgs()){
            logger.info(o.toString());
        }
    }

    @AfterReturning(pointcut = "allAuditedMethods()",
    returning = "result")
    private void afterReturningLogging(JoinPoint point, Object result){
        logger.info("AUDITING::: " + point.getSignature().toShortString() + " finished execution -> with result: " + result);
    }
}
