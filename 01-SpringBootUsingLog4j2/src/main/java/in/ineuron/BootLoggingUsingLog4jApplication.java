package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.ineuron.beans.Student;

@ImportResource(locations = "applicationContext.xml")
@SpringBootApplication
public class BootLoggingUsingLog4jApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootLoggingUsingLog4jApplication.class, args);

		Student student = context.getBean(Student.class);
		System.out.println(student);
		
		student.preparation("java");

		((ConfigurableApplicationContext) context).close();
	}

}
