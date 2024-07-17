package com.shiroya.Findjob.aop;

	import org.aspectj.lang.JoinPoint;
	import org.aspectj.lang.annotation.After;
	import org.aspectj.lang.annotation.AfterReturning;
	import org.aspectj.lang.annotation.AfterThrowing;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.Before;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Component;


	@Aspect
	@Component
	public class LoggingAspect {

		public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
		
		@Before("execution (* com.shiroya.Findjob.service.JobService.getAllJobs(..)) || execution(* com.shiroya.Findjob.service.JobService.addJob(..)) || execution (* com.shiroya.Findjob.service.JobService.getJob(..)) || execution(* com.shiroya.Findjob.service.JobService.updateJob(..)) || execution (* com.shiroya.Findjob.service.JobService.deleteJob(..)) || execution(* com.shiroya.Findjob.service.JobService.search(..))")
		public void logMethodCall(JoinPoint jp) {
			LOGGER.info("Method Called "+jp.getSignature().getName());
		}
		
		
		
		@After("execution (* com.shiroya.Findjob.service.JobService.getAllJobs(..)) || execution(* com.shiroya.Findjob.service.JobService.addJob(..)) || execution (* com.shiroya.Findjob.service.JobService.getJob(..)) || execution(* com.shiroya.Findjob.service.JobService.updateJob(..)) || execution (* com.shiroya.Findjob.service.JobService.deleteJob(..)) || execution(* com.shiroya.Findjob.service.JobService.search(..))")
		public void logMethodExecuted(JoinPoint jp) {
			LOGGER.info("Method Executed "+jp.getSignature().getName());
		}
		
		
		@AfterThrowing("execution (* com.shiroya.Findjob.service.JobService.getAllJobs(..)) || execution(* com.shiroya.Findjob.service.JobService.addJob(..)) || execution (* com.shiroya.Findjob.service.JobService.getJob(..)) || execution(* com.shiroya.Findjob.service.JobService.updateJob(..)) || execution (* com.shiroya.Findjob.service.JobService.deleteJob(..)) || execution(* com.shiroya.Findjob.service.JobService.search(..))")
		public void logMethodCrashed(JoinPoint jp) {
			LOGGER.info("Method has some issues "+jp.getSignature().getName());
		}
		
		
		
		@AfterReturning("execution (* com.shiroya.Findjob.service.JobService.getAllJobs(..)) || execution(* com.shiroya.Findjob.service.JobService.addJob(..)) || execution (* com.shiroya.Findjob.service.JobService.getJob(..)) || execution(* com.shiroya.Findjob.service.JobService.updateJob(..)) || execution (* com.shiroya.Findjob.service.JobService.deleteJob(..)) || execution(* com.shiroya.Findjob.service.JobService.search(..))")
		public void logMethodExecutedSuccess(JoinPoint jp) {
			LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
		}
	}