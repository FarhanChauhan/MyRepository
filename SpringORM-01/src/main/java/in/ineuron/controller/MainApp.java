package in.ineuron.controller;

import java.io.BufferedReader;


import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentService;

public class MainApp {

public static void main(String[] args) {

	ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	IStudentService service = factory.getBean(IStudentService.class);
	String id=null,sname=null,sage=null,saddress=null;
	StudentDTO dto=null;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	try {
		while(true) {
				
			System.out.println("1. CREATE");
			System.out.println("2. READ BY ID");
			System.out.println("3. READ ALL RECORDS");
			System.out.println("4. UPDATE");
			System.out.println("5. DELETE WITH RESPECT TO ID");
			System.out.println("6. DELETE WITH RESPECT TO BEAN");
			System.out.println("7. EXIT");
			System.out.print("Your Option :: [1,2,3,4,5,6,7]:: ");
			Integer option = Integer.parseInt(br.readLine());
				
			switch(option) {
				case 1:
					System.out.print("Enter the name:: ");
					sname = br.readLine();

					System.out.print("Enter the age:: ");
					sage = br.readLine();

					System.out.print("Enter the address:: ");
					saddress = br.readLine();

					dto = new StudentDTO();
					dto.setSname(sname);
					dto.setSage(Integer.parseInt(sage));
					dto.setSaddress(saddress);
					int rowAffected = service.insert(dto);
					System.out.println("ID of the record saved is : " +rowAffected);
					break;
					
				case 2:
					System.out.print("Enter the ID:: ");
					id = br.readLine();

					dto =new StudentDTO();
					dto = service.getStudent(Integer.parseInt(id));
					if(dto!=null) {
						System.out.println("Record for the id is : "+ dto);						
					}
					else {
						System.out.println("No Records found for the given id : "+id);
					}
				break;
			
				case 3:
						List<StudentDTO> students = service.getAllStudents();
						students.forEach(System.out::println);					
					break;

				case 4:
					System.out.print("Enter the new id :: ");
					id = br.readLine();

					System.out.print("Enter the new name :: ");
					sname = br.readLine();

					System.out.print("Enter the new age:: ");
					sage = br.readLine();

					System.out.print("Enter the new address:: ");
					saddress = br.readLine();

					dto = new StudentDTO();
					dto.setSid(Integer.parseInt(id));
					dto.setSname(sname);
					dto.setSage(Integer.parseInt(sage));
					dto.setSaddress(saddress);
					service.update(dto);
					break;
				
				case 5:
					System.out.print("Enter the ID:: ");
					id = br.readLine();
					service.delete(Integer.parseInt(id));
					break;
				
				case 6:
					System.out.print("Enter the id of the record:: ");
					id = br.readLine();
					System.out.print("Enter the name:: ");
					sname = br.readLine();

					System.out.print("Enter the age:: ");
					sage = br.readLine();

					System.out.print("Enter the address:: ");
					saddress = br.readLine();

					dto = new StudentDTO();
					dto.setSname(sname);
					dto.setSage(Integer.parseInt(sage));
					dto.setSaddress(saddress);
					service.delete(Integer.parseInt(id));
					break;
				
				case 7:
					System.out.println("****** THANK TOU FOR USIG THE APPLICATION ******");
					System.exit(0);
					break;
					
				default:
					System.out.println("PLEASE ENTER VALID OPERATION FROM 1 - 7 ! ");
				}
				
			}
		}
	catch(DataAccessException de) {
		de.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		((AbstractApplicationContext)factory).close();
	}
		
}

}