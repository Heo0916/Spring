package com.myway.tok.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Advice : 부가기능을 담당하는 역할. 로깅을 담당할 클래스를
public class MyLoggingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(MyLoggingAdvice.class); 
	
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		//추가 로직
		logger.info(joinPoint.getSignature().toString());
		
		//메소드 실행
		return joinPoint.proceed();
	}

}
