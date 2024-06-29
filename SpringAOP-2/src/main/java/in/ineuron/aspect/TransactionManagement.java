package in.ineuron.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	//PointCut
	@Pointcut("execution(public * in.ineuron.dao.*.saveEmployee())")
	public void p1() {}
	
	@Around(value = "p1()")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		
		System.out.println("Before method call");
		Object obj = jp.proceed();
		System.out.println(obj);
		System.out.println("After method call");
	}
	
//	@Before("p1()")//joinPoint
//	public void beginTranx() {
//		System.out.println("Transaction is begin....");
//	}
////	
////	@AfterReturning(value="p1()",returning="obj")
////	public void commitTransx(Object obj) {
////		System.out.println("Transaction is commited...");
////		System.out.println(obj);
////	}
////	
////	@AfterThrowing(value="p1()",throwing ="obj")
////	public void rollbackTrnsx(Throwable obj) {
////		System.out.println("Transactioin is rollbacked...");
////		System.out.println(obj);
////		
////	}
////	
////	@After("p1()")
////	public void emailSetupCredentials() {
////		System.out.println("****Email setup completed***");
////	}
}

