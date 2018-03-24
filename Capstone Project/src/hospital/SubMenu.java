package hospital;
/////////////////////////SubMenu.java includes interface SubMenu, classes PatientList, StaffList, & DeptList
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface SubMenu {
	Scanner in = new Scanner(System.in);
	
	public void listAll();
	public void addOne();
	public void searchOne(int id);
	public void editOne(int id);
	public void deleteOne(int id);
	public void returnMain();
	
}

class PatientList implements SubMenu {
	
	private ArrayList<Patient> patients;
	
	public PatientList(ArrayList<Patient> p){
		patients = p;
	}
	
	public void setPatients(ArrayList<Patient> p){
		patients = p;
	}
	
	public ArrayList<Patient> getPatients(){
		return patients;
	}
	
	public void listAll(){
		
		System.out.printf("%n%-15s%-15s%-12s%-12s%-10s%-10s%-20s%-18s%-8s%-8s%-15s%-30s%n%n","First Name","Last Name","PatientID",
	   			 "DoctorID","DOB","Gender","Street Address","City","State","Zip","Phone","Email");
		
		for(int i = 0; i < patients.size(); i++){
			System.out.printf("%-15s%-15s%-12d%-12d%-10s%-10s%-5s%-15s%-18s%-8s%-8s%-15s%-30s%n",
					patients.get(i).getFirst(),
					patients.get(i).getLast(),
					patients.get(i).getID(),
					patients.get(i).getDoc(),
					patients.get(i).getPersonalDetails().getBday(),
					patients.get(i).getPersonalDetails().getGender(),
					patients.get(i).getAddress().getNo(),
					patients.get(i).getAddress().getStreet(),
					patients.get(i).getAddress().getCity(),
					patients.get(i).getAddress().getState(),
					patients.get(i).getAddress().getZip(),
					patients.get(i).getContact().getPhone(),
					patients.get(i).getContact().getEmail());}
		
		
	}
	public void addOne(){
		
		System.out.print("Enter Patient's First Name: ");
		String fname = in.next();
		System.out.print("Enter Patient's Last Name: ");
		String lname = in.next();
		System.out.print("Enter Patient's Date Of Birth (format: M/D/YYYY) : ");
		String bday = in.next();
		System.out.print("Enter Patient's Gender (format: 'F' for female, 'M' for male): ");
		String gend = in.next();
		int pID = 0;
		try{
		System.out.print("Enter Patient's ID: ");
		pID = in.nextInt();
		for(int i = 0; i < patients.size(); i++){
			if(pID == patients.get(i).getID()){
				throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
			}
			}//end of for loop
		}
		catch(InputMismatchException inputmismatch){
			System.err.println("Invalid entry. Input is not a valid entry for ID.");
		}
		System.out.print("Enter Patient's Doctor's ID: ");
		int docID = in.nextInt();
		System.out.print("Enter Patient's house no. from street (Ex. 20): ");
		int num = in.nextInt();
		System.out.print("Enter Patient's Street: ");
		String street = in.next();
		System.out.print("Enter Patient's City: ");
		String city = in.next();
		System.out.print("Enter Patient's State (format: NY) : ");
		String state = in.next();
		System.out.print("Enter Patient's Zip Code (format: 11801) : ");
		String zip = in.next();
		System.out.print("Enter Patient's Phone No. : ");
		String phone = in.next();
		System.out.print("Enter Patient's Email: ");
		String email = in.next();
		
		ContactAddress addContact = new ContactAddress(num,street,city,state,zip,phone,email);
		PersonalInfo addPersonal = new PersonalInfo(bday,gend);
		Patient addPatient = new Patient(fname,lname,pID,docID,addPersonal,addContact);
		
		patients.add(addPatient);
		System.out.println("Patient Record Added. \n");
		
	}
	public void searchOne(int id){
		
		System.out.printf("%n%-15s%-15s%-12s%-12s%-10s%-10s%-20s%-18s%-8s%-8s%-15s%-30s%n%n","First Name","Last Name","PatientID",
   			 "DoctorID","DOB","Gender","Street Address","City","State","Zip","Phone","Email");
	
		for(int i = 0; i < patients.size(); i++){
			if(patients.get(i).getID() == id){
				System.out.printf("%-15s%-15s%-12d%-12d%-10s%-10s%-5s%-15s%-18s%-8s%-8s%-15s%-30s%n",
						patients.get(i).getFirst(),
						patients.get(i).getLast(),
						patients.get(i).getID(),
						patients.get(i).getDoc(),
						patients.get(i).getPersonalDetails().getBday(),
						patients.get(i).getPersonalDetails().getGender(),
						patients.get(i).getAddress().getNo(),
						patients.get(i).getAddress().getStreet(),
						patients.get(i).getAddress().getCity(),
						patients.get(i).getAddress().getState(),
						patients.get(i).getAddress().getZip(),
						patients.get(i).getContact().getPhone(),
						patients.get(i).getContact().getEmail());}
				
			}
						
	}
	
	public void editOne(int id){
					
		for(int i = 0; i < patients.size(); i++){
		
		if(patients.get(i).getID() == id){
		System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n","-- EDIT MENU --", "(1) First Name","(2) Last Name",
				"(3) ID", "(4) Doctor ID","(5) Date Of Birth","(6) Gender","(7) Address","(8) Phone Number","(9) Email","(10) Exit Edit");
		int edit = in.nextInt();
		
		switch(edit){
		
		case 1:
			System.out.print("Enter First Name: ");
			String fname = in.next();
			patients.get(i).setFirst(fname);
				break;
		case 2:
			System.out.print("Enter Last Name: ");
			String lname = in.next();
			patients.get(i).setFirst(lname);
				break;
		case 3:
			int editID = 0;
			System.out.print("Enter ID: ");
			try{
				editID = in.nextInt();
				for(int b = 0; i < patients.size(); b++){
					if(editID == patients.get(b).getID()){
						throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
					}
					}//end of for loop
				}
				catch(InputMismatchException inputmismatch){
					System.err.println("Invalid entry. Input is not a valid entry for ID.");
				}
				patients.get(i).setID(editID);
				break;
		case 4:
			System.out.print("Enter Department ID: ");
			int docID = in.nextInt();
			patients.get(i).setDoc(docID);
				break;
		case 5:
			System.out.print("Enter Date Of Birth: ");
			String bday = in.next();
			patients.get(i).getPersonalDetails().setBday(bday);
				break;
		case 6:
			System.out.print("Enter Gender (format: 'F' for female, 'M' for male): ");
			String gend = in.next();
			patients.get(i).getPersonalDetails().setGender(gend);
				break;
		case 7:
				int flag = 0;
				while(flag != 6){
				System.out.printf("%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "-- EDIT ADDRESS --","(1) Street No.","(2) Street Name",
						"(3) City","(4) State","(5) Zip Code","(6) Exit Address Edit"); 
				flag = in.nextInt();
				if(flag == 1){
					System.out.print("Enter Street No. : ");
					int snum = in.nextInt();
					patients.get(i).getAddress().setNo(snum);
					}
				else if(flag == 2){
					System.out.print("Enter Street Name: ");
					String street = in.nextLine();
					patients.get(i).getAddress().setStreet(street);
					}
				else if(flag == 3){
					System.out.print("Enter City: ");
					String city = in.next();
					patients.get(i).getAddress().setCity(city);
					}
				else if(flag == 4){
					System.out.print("Enter State (format ex. New York enter 'NY'): ");
					String state = in.next();
					patients.get(i).getAddress().setState(state);
					}
				else if(flag == 5){
					System.out.print("Enter Zip Code: ");
					String zip = in.next();
					patients.get(i).getAddress().setZip(zip);
					}
				else if(flag == 6){
					System.out.println("Returning to Edit Patient Menu. \n");
					}
				else System.out.println("Invalid Entry. \n");			
				
				
				}//end of edit address while loop
				break;
		case 8:
				System.out.print("Enter Phone Number: ");
				String phone = in.next();
				patients.get(i).getContact().setPhone(phone);
				break;
		case 9:
				System.out.print("Enter Email: ");
				String email = in.next();
				patients.get(i).getContact().setEmail(email);
				break;
		case 10:
				System.out.println("Returning to Staff Sub Menu.\n");
				break;
		default:
				System.out.println("Invalid Entry. \n");
			
		}//end of switch
		
		}//end of if
		else if(i == patients.size() - 1){System.out.println("No Patient ID found in records.");}
		
		}//end of for loop
		
		
	}
	public void deleteOne(int id){
		
		for(int i = 0; i < patients.size(); i++){
			if(patients.get(i).getID() == id){
				patients.remove(i);
				System.out.println("Patient's Record is Removed. \n");
				break;
			}
		}
		
	}
	public void returnMain(){
		System.out.println("Returning to Main Menu from Patients Menu. \n");
	}
	
}//end of class PetientList

class DeptList implements SubMenu {
	
	private ArrayList<Department> departments;
	
	public DeptList(ArrayList<Department> d){
		departments = d;
		
	}
	
	public void setDepts(ArrayList<Department> d){
		departments = d;
	}
	
	public ArrayList<Department> getDepts(){
		return departments;
	}
	
	public void listAll(){
		  System.out.printf("%-20s%-30s%n%n",
	    		  "Department Name",
	    		  "Department ID");
		
		for(int i = 0; i < departments.size(); i++){
			System.out.printf("%-20s%-30s%n", departments.get(i).getDeptName(),departments.get(i).getID());
		}
		
	}
	public void addOne(){
		
		System.out.print("Enter Department's ID: ");
		int deptID = 0;
		try{
		deptID = in.nextInt();
		for(int i = 0; i < departments.size(); i++){
		if(deptID == departments.get(i).getID()){
			throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
		}
		}//end of for loop
		}catch(InputMismatchException inputMismatch){
			
		}
		System.out.print("Enter Department Name: ");
		String deptName = in.next();
		
		Department addDept = new Department(deptName,deptID);
		departments.add(addDept);
		System.out.println("Department Record Added. ");
		
	}
	
	public void searchOne(int id){
		
		for(int i = 0; i < departments.size(); i++){
			if(departments.get(i).getID() == id){
				System.out.printf("%-20s%-30s%n%n","Department Name","Department ID");
				System.out.printf("%-20s%-30s%n", departments.get(i).getDeptName(),departments.get(i).getID());
				break;
			}
		}
		
	}
	
	public void editOne(int id){
		
			
		for(int i = 0; i < departments.size(); i++){
		
		if(departments.get(i).getID() == id){
		System.out.printf("%n%14s%n%s%n%s%n%s%n","-- EDIT MENU --", "(1) Department Name","(2) Department ID","(3)Exit Edit");
		int edit = in.nextInt();
		
		switch(edit){
		
		case 1:
				System.out.print("Enter Department Name: ");
				String deptName = in.next();
				departments.get(i).setDeptName(deptName);
				break;
		case 2:
				System.out.print("Enter Department's ID: ");
				try{
				int deptID = in.nextInt();
				for(int b = 0; i < departments.size(); b++){
					if(deptID == departments.get(b).getID()){
						throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
					}
					}//end of for loop
				departments.get(i).setID(deptID);}
				catch(InputMismatchException inputMismatch){
					System.err.println("Input invalid. Input is not valid to set ID. ");
					
					}
				break;
		case 3:
				System.out.println("Returning to Department Sub Menu.");
				break;
			
		default:
				System.out.println("Invalid Entry. \n");
			
		}//end of switch
		
		}//end of if
		else if(i == departments.size() - 1){System.out.println("No Department ID found in records."); }
		
		}//end of for loop
		
	}
	
	public void deleteOne(int id){
		
		for(int i = 0; i < departments.size(); i++){
			if(departments.get(i).getID() == id){
				departments.remove(i);
				System.out.println("Department Record Removed. ");
				break;
			}
		}
		
	}
	
	public void returnMain(){
		System.out.println("Returning to Main Menu from Department Menu.\n");
	}
	
}//end of class DeptList

class StaffList implements SubMenu {
	
	private ArrayList<Staff> staff;
	
	public StaffList(ArrayList<Staff> s){
		staff = s;
		
	}
	
	public void setStaff(ArrayList<Staff> s){
		staff = s;
	}
	
	public ArrayList<Staff> getStaff(){
		return staff;
	}
	
	public void listAll(){
		
		System.out.printf("%n%-7s%-15s%-15s%-12s%-12s%-10s%-10s%-15s%-30s%n%n","Type","First Name","Last Name","StaffID",
	   			 "DeptID","DOB","Gender","Phone","Email");
		
		for(int i = 0; i < staff.size(); i++){
			System.out.printf("%-7s%-15s%-15s%-12d%-12d%-10s%-10s%-15s%-30s%n",
					staff.get(i).getType(),
					staff.get(i).getFirst(),
					staff.get(i).getLast(),
					staff.get(i).getID(),
					staff.get(i).getDept(),
					staff.get(i).getPersonalDetails().getBday(),
					staff.get(i).getPersonalDetails().getGender(),
					staff.get(i).getContact().getPhone(),
					staff.get(i).getContact().getEmail());}
		
	}
	
	public void addOne(){
		
		System.out.print("Enter Staff Type (Example: for doctor enter 'D', administrative enter 'A', nurse enter 'N'): ");
		String type = in.next();
		System.out.print("Enter Staff Member's First Name: ");
		String fname = in.next();
		System.out.print("Enter Staff Member's Last Name: ");
		String lname = in.next();
		System.out.print("Enter Staff Member's Date Of Birth (format: M/D/YYYY) : ");
		String bday = in.next();
		System.out.print("Enter Staff Member's Gender (format: 'F' for female, 'M' for male): ");
		String gend = in.next();
		System.out.print("Enter Staff Member's ID: ");
		int ID = 0;
		try{
		ID = in.nextInt();
		for(int i = 0; i < staff.size(); i++){
			if(ID == staff.get(i).getID()){
				throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
			}
			}//end of for loop
		}
		catch(InputMismatchException inputmismatch){
			System.err.println("Invalid entry. Input is not a valid entry for ID.");
		}
		System.out.print("Enter Staff Member's Department ID: ");
		int deptID = in.nextInt();
		System.out.print("Enter Staff Member's Phone No. : ");
		String phone = in.next();
		System.out.print("Enter Staff Member's Email: ");
		String email = in.next();
		
		Contact addContact = new Contact(phone,email);
		PersonalInfo addPersonal = new PersonalInfo(bday,gend);
		Staff addStaff = new Staff(type,fname,lname,ID,deptID,addPersonal,addContact);
		staff.add(addStaff);
		System.out.println("Staff Record Added. \n");
	}
	
	public void searchOne(int id){
		
		System.out.printf("%n%-7s%-15s%-15s%-12s%-12s%-10s%-10s%-15s%-30s%n%n","Type","First Name","Last Name","StaffID",
	   			 "DeptID","DOB","Gender","Phone","Email");
		
			for(int i = 0; i < staff.size(); i++){
				if(staff.get(i).getID() == id){
					System.out.printf("%-7s%-15s%-15s%-12d%-12d%-10s%-10s%-15s%-30s%n",
							staff.get(i).getType(),
							staff.get(i).getFirst(),
							staff.get(i).getLast(),
							staff.get(i).getID(),
							staff.get(i).getDept(),
							staff.get(i).getPersonalDetails().getBday(),
							staff.get(i).getPersonalDetails().getGender(),
							staff.get(i).getContact().getPhone(),
							staff.get(i).getContact().getEmail());}
					
				}
			
			
		
	}
	public void editOne(int id){
					
		for(int i = 0; i < staff.size(); i++){
		
		if(staff.get(i).getID() == id){
		System.out.printf("%n%14s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n","-- EDIT MENU --", "(1) Type","(2) First Name","(3) Last Name",
				"(4) ID", "(5) Department ID","(6) Date Of Birth","(7) Gender","(8) Phone Number","(9) Email","(10) Exit Edit");
		int edit = in.nextInt();
		
		switch(edit){
		
		case 1:
				System.out.print("Enter Type (format: doctor enter 'D', nurse enter 'N', administrative enter 'A'): ");
				String type = in.next();
				staff.get(i).setType(type);
				break;
		case 2:
				System.out.print("Enter First Name: ");
				String fname = in.next();
				staff.get(i).setFirst(fname);
				break;
		case 3:
				System.out.print("Enter Last Name: ");
				String lname = in.next();
				staff.get(i).setFirst(lname);
				break;
		case 4:
				System.out.print("Enter ID: ");
				int editID = 0;
				try{
				editID = in.nextInt();
				for(int b = 0; b < staff.size(); b++){
					if(editID == staff.get(b).getID()){
						throw new IllegalArgumentException("ID is already on records. Cannot add ID inputed.");
					}
					}//end of for loop
				}
				catch(InputMismatchException inputmismatch){
					System.err.println("Invalid entry. Input is not a valid entry for ID.");
				}
				staff.get(i).setID(editID);
				break;
		case 5:
				System.out.print("Enter Department ID: ");
				int deptID = in.nextInt();
				staff.get(i).setDept(deptID);
				break;
		case 6:
				System.out.print("Enter Date Of Birth: ");
				String bday = in.next();
				staff.get(i).getPersonalDetails().setBday(bday);
				break;
		case 7:
				System.out.print("Enter Gender (format: 'F' for female, 'M' for male): ");
				String gend = in.next();
				staff.get(i).getPersonalDetails().setGender(gend);
				break;
		case 8:
				System.out.print("Enter Phone Number: ");
				String phone = in.next();
				staff.get(i).getContact().setPhone(phone);
				break;
		case 9:
				System.out.print("Enter Email: ");
				String email = in.next();
				staff.get(i).getContact().setEmail(email);
				break;
		case 10:
				System.out.println("Returning to Staff Sub Menu.\n");
				break;
		default:
				System.out.println("Invalid Entry. \n");
			
		}//end of switch
		
		}//end of if
		else if(i == staff.size() - 1){System.out.println("No Staff ID found in records.");} 
		
		}//end of for loop
		
		
	}
	public void deleteOne(int id){
		
		for(int i = 0; i < staff.size(); i++){
			if(staff.get(i).getID() == id){
				staff.remove(i);
				System.out.println("Staff Member's Record is Removed. \n");
				break;
			}
		}
		
	}
	
	public void returnMain(){
		System.out.println("Returning to Main Menu from Staff Menu.\n");
	}
	
}//end of class StaffList



