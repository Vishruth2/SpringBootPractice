package com.nt.runners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;

@Component
public class MarriageRunners implements CommandLineRunner {

	@Autowired
	private IMatrimonyServiceMgmt msrepo;
	
	@Override
	public void run(String... args) throws Exception {
	
		try(Scanner scn=new Scanner(System.in);) {
			
				System.err.println("Enter the Person Name :: ");
				String sname= scn.nextLine();
				System.err.println("Enter the Person address :: ");
				String sadd = scn.nextLine();
				System.err.println("Enter the person photo file complete path :: ");
				String photoPath = scn.next().replace("?","");
				System.err.println("Enter the person bio data");
				String bioData = scn.next().replace("?","");
				System.err.println("Is the person is Indian  ?");
				boolean indian = scn.nextBoolean();
				
				//Prepare byte[] representing photo file content
				InputStream is = new FileInputStream(photoPath);
				byte[] photoData = is.readAllBytes();
				
				//prepare char[] representing bioData file Content
				File file = new File(bioData);
				char[] bioDataContent = new char[((int)file.length())];
				Reader reader = new FileReader(file);
				reader.read(bioDataContent);
				
				//prepare entity class object
				MarriageSeeker seeker = new MarriageSeeker(sname, sadd, photoData, LocalDateTime.of(1990, 11, 23,12,45), bioDataContent);
				System.err.println(msrepo.registerMarriageSeeker(seeker));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
/*		try {
			Optional<MarriageSeeker> opt=msrepo.searchSeekerById(1L);
			if (opt.isPresent()) {
				MarriageSeeker seek = opt.get();
				System.err.println(seek.getName()+"....."+seek.getDateOfBirth()+"......."+seek.getAddress()+"........");
				OutputStream os = new FileOutputStream("retrived_photo.jpg");
				os.write(seek.getPhoto());
				os.flush();
				
				Writer wr = new FileWriter("retrieved_data.txt");
				wr.write(seek.getBioData());
				wr.flush();
				
				os.close();
				wr.close();
				System.err.println("LOB's are retrieved......");
			} else {
				System.err.println("Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
		    List<MarriageSeeker> list = msrepo.showAll();
		    for (MarriageSeeker seek : list) {
		        System.out.println();
		        System.err.println(seek.getName() + "....." + seek.getDateOfBirth() + "......."
		                + seek.getAddress() + "........");

		        // Save photo details
		        byte[] photo = seek.getPhoto();
		        if (photo != null && photo.length > 0) {
		            try (FileOutputStream fos = new FileOutputStream(seek.getName() + ".jpg")) {
		                fos.write(photo);
		                fos.flush();
		                System.err.println("Saved photo for: " + seek.getName());
		            } catch (IOException e) {
		                System.err.println("Error saving photo for " + seek.getName());
		                e.printStackTrace();
		            }
		        }

		        // Save bio data to file
		        char[] bioData = seek.getBioData();
		        if (bioData != null && bioData.length > 0) {
		            // Using BufferedWriter for better performance
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(seek.getName() + ".txt"))) {
		                writer.write(bioData);
		                writer.flush();
		                System.err.println("Saved bio data for: " + seek.getName());
		            } catch (IOException e) {
		                System.err.println("Error saving bio data for " + seek.getName());
		                e.printStackTrace();
		            }
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}


	}

}
