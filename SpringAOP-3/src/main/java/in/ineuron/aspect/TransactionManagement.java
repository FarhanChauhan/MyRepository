package in.ineuron.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	//PointCut
	@Pointcut("@annotation(in.ineuron.annotation.MyTransaction)")
	public void p1() {}

	
	@Before("p1()")//joinPoint
	public void beginTranx() {
		System.out.println("Transaction is begin....");
	}
		
	@After("p1()")//joinPoint
	public void afterTranx() {
		System.out.println("Transaction is commited....");

	}
}

