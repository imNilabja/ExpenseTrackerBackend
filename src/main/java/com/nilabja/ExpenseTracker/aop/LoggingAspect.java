package com.nilabja.ExpenseTracker.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LoggingAspect.class);

    private String getMethodPath(JoinPoint jp) {
        String fullClassName = jp.getSignature().getDeclaringTypeName();
        String className = jp.getSignature().getDeclaringType().getSimpleName();
        String methodName = jp.getSignature().getName();

        String layer;
        if (fullClassName.contains(".controller.")) {
            layer = "controller";
        } else if (fullClassName.contains(".service.")) {
            layer = "service";
        } else if (fullClassName.contains(".repo.")) {
            layer = "repo";
        } else {
            layer = "unknown";
        }

        return layer + "/" + className + "/" + methodName;
    }

    @Before(
            "execution(* com.nilabja.ExpenseTracker.service..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.repo..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.controller..*(..))"
    )
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("Method started: {}", getMethodPath(jp));
    }

    @AfterThrowing(
            "execution(* com.nilabja.ExpenseTracker.service..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.repo..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.controller..*(..))"
    )
    public void logMethodError(JoinPoint jp) {
        LOGGER.error("Error in Method: {}", getMethodPath(jp));
    }

    @AfterReturning(
            "execution(* com.nilabja.ExpenseTracker.service..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.repo..*(..)) || " +
                    "execution(* com.nilabja.ExpenseTracker.controller..*(..))"
    )
    public void logMethodComplete(JoinPoint jp) {
        LOGGER.info("Method completed: {}", getMethodPath(jp));
    }
}
