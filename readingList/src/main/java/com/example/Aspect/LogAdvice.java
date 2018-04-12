package com.example.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.controllers.Users;

@Aspect
@Component
public class LogAdvice {

	Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	@Around("execution(* com.example.controllers.Users.*())")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("entring Method "+pjp.getSignature());
        long startTime = System.currentTimeMillis();

        Object retVal = pjp.proceed();
        // stop stopwatch
        long endTime= System.currentTimeMillis();
        logger.info("after Method "+pjp.getSignature());
        logger.info("Time taken to execute "+pjp.getSignature() +"in MS  "+(endTime-startTime));
        return retVal;
    }

}
