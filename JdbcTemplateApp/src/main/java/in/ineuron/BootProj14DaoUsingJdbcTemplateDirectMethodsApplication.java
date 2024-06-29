package in.ineuron;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IEmployeeService;

@SpringBootApplication
public class BootProj14DaoUsingJdbcTemplateDirectMethodsApplication 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
    	ApplicationContext context = SpringApplication
				.run(BootProj14DaoUsingJdbcTemplateDirectMethodsApplication.class, args);
    	IEmployeeService service = context.getBean(IEmployeeService.class);
    	try {
	    	int recordCount = service.fetchEmployeeCount();
	    	String ename = service.fetchEmployeeNameById(1);
	    	Map<String, Object> employeeRecords = service.fetchEmployeedetailsById(1);
	    	service.fetchEmployeedetailsByaddresss("RCB","fatema nagar").forEach(System.out::println);
	    	int rowsAffected = service.insertEmployee("virat", 25000, "fatema nagar");
	    	int rowsUpdated = service.addBonusByAge(5000, "fatema nagar");
	    	System.out.println("The name of employee is : "+ename);
	    	System.out.println("No of rows are :: "+recordCount);
	    	System.out.println("The employee Record is : "+employeeRecords);
	    	System.out.println(rowsUpdated);
	    	System.out.println(rowsAffected);
	    	
    	}
    	catch(Exception e) {
    		System.out.println("Error occured : "+ e.getMessage());
    	}
	    ((ConfigurableApplicationContext)context).close();
    }
}
