package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(20)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterNoSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n ===========> @Before advice on addAccount()");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
		
	}
	
}
