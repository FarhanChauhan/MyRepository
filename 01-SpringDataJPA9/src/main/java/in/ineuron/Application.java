package in.ineuron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.MarraigeSeeker;
import in.ineuron.service.IMatromonyMgmntService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		IMatromonyMgmntService service = context.getBean(IMatromonyMgmntService.class);
	
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("Enter the name : ");
//		String name = scanner.next();
//		
//		System.out.println("Enter the address : ");
//		String address = scanner.next();
//		
//		System.out.println("Enter the photoPath : ");
//		String photoPath = scanner.next();
//		
//		System.out.println("Enter the bioDataPath : ");
//		String bioDataPath = scanner.next();
//		
//		System.out.println("Indian or not : (true/false) ");
//		Boolean indian = scanner.nextBoolean();
//		
//		InputStream inputStream = new FileInputStream(photoPath);
//		byte[] photo = new byte[inputStream.available()];
//		inputStream.read(photo);
//		
//		File file = new File(bioDataPath);
//		FileReader reader = new FileReader(file);
//		char[] bioData = new char[(int) file.length()];
//		
//		MarraigeSeeker marraigeSeeker = new MarraigeSeeker(name,address,LocalDateTime.of(1983, 10, 20, 20, 15),indian,bioData,photo);
//		String status = service.addSeeker(marraigeSeeker);
//		System.out.println(status);
		
		Optional<MarraigeSeeker> optional = service.fetchSeekersById(1);
		if(optional.isPresent()) {
			MarraigeSeeker seekers = optional.get();
			System.out.println(seekers.getId()+" "+seekers.getName()+" "+seekers.getAddresss()+" "+seekers.getDob());
		
			FileOutputStream outputStream = new FileOutputStream("retrive_photo.png");
			outputStream.write(seekers.getPhoto());
			outputStream.flush();
			FileWriter writer = new FileWriter("retrive_bioData.txt");
			writer.write(seekers.getBioData());
			writer.flush();
			System.out.println("Data Retrived successfully..");		
			outputStream.close();
			writer.close();
	
		}
		else
		{
			System.out.println("Record Not Found ..");
		}
		((ConfigurableApplicationContext) context).close();
	}

}
