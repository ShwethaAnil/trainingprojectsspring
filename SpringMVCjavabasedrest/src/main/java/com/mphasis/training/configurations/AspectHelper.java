package com.mphasis.training.configurations;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHelper {
	
	@Before("execution(* com.mphasis.daos.*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		System.out.println("before dao methods");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}
	
	/* @Around("execution(* com.mphasis.daos.*.*(..))")
	    public void logAroundAllMethods(
	    		ProceedingJoinPoint joinPoint) throws Throwable
	    {
	        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": Before Method Execution");
	        try {
	            joinPoint.proceed();
	        } finally {
	            //Do Something useful, If you have
	        }
	        System.out.println("****LoggingAspect.logAroundAllMethods() : " + joinPoint.getSignature().getName() + ": After Method Execution");
	    }*/
	 
}
