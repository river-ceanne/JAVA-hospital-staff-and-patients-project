package hospital;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HospitalMain {
	
	private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;
	private static ArrayList<Department> deptsArray = new ArrayList<Department>();
	private static ArrayList<Staff> staffArray = new ArrayList<Staff>();
	private static ArrayList<Patient> patientsArray = new ArrayList<Patient>();

	public static void main(String[] args) {
		
		System.out.println("Welcome To The Hospital Records System!\n\n "
				+ "Openning log files...\n Hold on a sec...\n\n"); 
		openFile();
		readRecords();
		closeFile();
	
		int main = 0, submenu = 0; // user input from main menu and sub menu
		Scanner scan = new Scanner(System.in); 
		DeptList depts = new DeptList(deptsArray);
		PatientList patients = new PatientList(patientsArray); 
		StaffList staff = new StaffList(staffArray);
	
		System.out.printf("%17s%n","-- MAIN MENU --");
		System.out.printf("%s%n%s%n%s%n%s%n", "(1) Department Menu","(2) Staff Menu","(3) Patient Menu","(4) Exit");
		
		main = scan.nextInt();
		submenu = 0;
		
	while(main != 4){// flags variable main to exit loop
		
	while(submenu != 6){
		System.out.printf("%n%n%14s%n","-- SUBMENU --");
		System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n", "(1) List All","(2) Add","(3) Search","(4) Edit",
				"(5) Delete", "(6) Return to Main Menu");
		submenu = scan.nextInt();
		
		switch(submenu){
		
		case 1: 
			if(main == 1){depts.listAll();}
			if(main == 2){staff.listAll();}
			if(main == 3){patients.listAll();}
			break;
		case 2:
			if(main == 1){depts.addOne();}
			if(main == 2){staff.addOne();}
			if(main == 3){patients.addOne();}
			break;
		case 3:
			System.out.print("\nEnter the ID of subject to search in records: ");
			{int id = scan.nextInt();
			if(main == 1){depts.searchOne(id);}
			if(main == 2){staff.searchOne(id);}
			if(main == 3){patients.searchOne(id);}
			}
			break;
		case 4:
			System.out.print("\nEnter the ID of subject to edit records: ");
			{int id = scan.nextInt();
			if(main == 1){depts.editOne(id);}
			if(main == 2){staff.editOne(id);}
			if(main == 3){patients.editOne(id);}
			}
			break;
		case 5:
			System.out.print("\nEnter the ID of subject to remove from records: ");
			{int id = scan.nextInt();
			if(main == 1){depts.deleteOne(id);}
			if(main == 2){staff.deleteOne(id);}
			if(main == 3){patients.deleteOne(id);}
			}
			break;
		case 6:
			if(main == 1){depts.returnMain();}
			if(main == 2){staff.returnMain();}
			if(main == 3){patients.returnMain();}
			break;
		default :
			System.out.println("Invalid entry.");

		}//end of switch
		
		}//end of while loop for Sub Menu
	
	System.out.printf("%17s%n","-- MAIN MENU --");
	System.out.printf("%s%n%s%n%s%n%s%n", "(1) Department Menu","(2) Staff Menu","(3) Patient Menu","(4) Exit");
	
	main = scan.nextInt();
	submenu = 0;
		
	}//end of while loop for Main Menu
	
	scan.close();
	updateFiles(depts,staff,patients);
	
	}// end of main************************************************************************************************
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void openFile()
	   {
	      try
	      {
	         input = new Scanner(Paths.get("C:\\Users\\Reina\\Documents\\BCS345 - Java\\d.txt")); 
	         input2 = new Scanner(Paths.get("C:\\Users\\Reina\\Documents\\BCS345 - Java\\s.txt")); 
	         input3 = new Scanner(Paths.get("C:\\Users\\Reina\\Documents\\BCS345 - Java\\p.txt")); 
	      } 
	      catch (IOException ioException)
	      {
	         System.err.println("Error opening file.");
	         System.exit(1);
	      } 
	      
	   }//end of openFile()
	
	 public static void readRecords()
	   {
	  
	      try //reading departments file
	      {
	    	 
	         while (input.hasNextLine()) // while there is more to read
	         {
	            
	        	 String theLine =input.nextLine(); // read the current line
	        	 
	        	 String[] fields = theLine.split(","); // split the line into fields
	        	 
	        	
	        	 String departmentName = fields[0];
	        	 int departmentID = Integer.parseInt(fields[1]);
	        	 
	        	 Department eachDept = new Department(departmentName, departmentID);
	        	 deptsArray.add(eachDept);
	        	 
	        	 
	        	 
	         }//end of while loop
	         
	         
	      } // end of try block
	      catch (NoSuchElementException elementException)
	      {
	         System.err.println("File improperly formed.");
	      } 
	      
	      
	     //****************************************************************************
	      
	      try //reading staff file
	      {
	    	 
	         while (input2.hasNextLine()) // while there is more to read
	         {
	            
	        	 String theLine =input2.nextLine(); // read the current line
	        	 
	        	 String[] fields = theLine.split(","); // split the line into fields
	        	 
	        	
	        	 String type = fields[0];
	        	 String fname = fields[1];
	        	 String lname = fields[2];
	        	 int staffID = Integer.parseInt(fields[3]);
	        	 int departmentID = Integer.parseInt(fields[4]);
	        	 String bday = fields[5];
	        	 String gend = fields[6];
	        	 String phone = fields[7];
	        	 String email = fields[8];
	        	 
	        	Contact eachContact = new Contact(phone,email);
	        	PersonalInfo eachPersonal = new PersonalInfo(bday,gend);
	        	Staff eachStaff = new Staff(type,fname,lname,staffID,departmentID,eachPersonal,eachContact);
	        	
	        	staffArray.add(eachStaff);
	        		
	         }//end of while loop
	         
	         
	      } // end of try block
	      catch (NoSuchElementException elementException)
	      {
	         System.err.println("File improperly formed.");
	      } 
	      catch (IllegalStateException stateException)
	      {
	         System.err.println("Error reading from file.");
	      } 
	      
	      //************************************************************************
	      
	      try //reading patients file
	      {
	    	  	    	  
	         while (input3.hasNextLine()) // while there is more to read
	         {
	            
	        	 String theLine =input3.nextLine(); // read the current line
	        	 
	        	 String[] fields = theLine.split(","); // split the line into fields
	        	 
	        	
	        	 String fname = fields[0];
	        	 String lname = fields[1];
	        	 int patientID = Integer.parseInt(fields[2]);
	        	 int docID = Integer.parseInt(fields[3]);
	        	 String bday = fields[4];
	        	 String gend = fields[5];
	        	 int num = Integer.parseInt(fields[6]);
	        	 String street = fields[7];
	        	 String city = fields[8];
	        	 String state = fields[9];
	        	 String zip = fields[10];
	        	 String phone = fields[11];
	        	 String email = fields[12];
	        	 
	        	ContactAddress eachContact = new ContactAddress(num,street,city,state,zip,phone,email);
	        	PersonalInfo eachPersonal = new PersonalInfo(bday,gend); 
	        	Patient eachPatient = new Patient(fname,lname,patientID,docID,eachPersonal,eachContact);	        	
	        	
	        	patientsArray.add(eachPatient);
	        		 
	         }//end of while loop
	         
	         
	      } // end of try block
	      catch (NoSuchElementException elementException)
	      {
	         System.err.println("File improperly formed.");
	      } 
	      catch (IllegalStateException stateException)
	      {
	         System.err.println("Error reading from file.");
	      } 
	      
	   } // end of readRecords()

	 public static void closeFile()
	   {
	      if (input != null)
	         input.close();
	      if (input2 != null)
	          input2.close();
	      if (input3 != null)
	          input3.close();
	   } //end of closeFile()
	 
	 public static void updateFiles(DeptList depts, StaffList staff, PatientList patients){
		 
		 try {
		      PrintStream output = new PrintStream(new FileOutputStream("C:\\Users\\Reina\\Documents\\BCS345 - Java\\deptsUpdated.txt"));
		      for (int i = 0; i < depts.getDepts().size(); i++)
		        output.println(depts.getDepts().get(i));

		      output.close();

		    } catch (IOException outputException) {
		    	System.err.println("Error writing file. Terminating.");
		    	outputException.printStackTrace();
		    }
		 
		 try {
		      PrintStream output = new PrintStream(new FileOutputStream("C:\\Users\\Reina\\Documents\\BCS345 - Java\\staffUpdated.txt"));
		      for (int i = 0; i < staff.getStaff().size(); i++)
		        output.println(staff.getStaff().get(i));

		      output.close();

		    } catch (IOException outputException) {
		    	System.err.println("Error writing file. Terminating.");
		    	outputException.printStackTrace();
		    }

		 try {
		      PrintStream output = new PrintStream(new FileOutputStream("C:\\Users\\Reina\\Documents\\BCS345 - Java\\patientsUpdated.txt"));
		      for (int i = 0; i < patients.getPatients().size(); i++)
		        output.println(patients.getPatients().get(i));//main calling to.String() of ContactAddress overriding Contact's to.String()

		      output.close();

		    } catch (IOException outputException) {
		    	System.err.println("Error writing file. Terminating.");
		    	outputException.printStackTrace();
		    }
	 }//end of updateFiles method
	 
}//end of class HospitalMain **********************************************************************************
