package hospital;
//This java file has class Person which is the super class of <<class>> Patient and <<class>>Staff
////////////////////////////////////////////<<class>>Patient and <<class>>Staff is in this file
public class Person {
	
	protected String firstName, lastName;
	protected int ID;
	protected Contact contact;
	protected PersonalInfo personalDetails;
	
	public Person(String f, String l, int id, PersonalInfo p, Contact c){
		firstName = f;
		lastName = l;
		ID = id;
		personalDetails = p;
		contact = c;
	}
	
	public void setFirst(String f){
		firstName = f;
	}
	
	public void setLast(String l){
		lastName = l;
	}
	
	public void setID(int id){
		ID = id;
	}
	
	public void setContact(Contact c){
		contact = c;
	}
	
	public void setPersonal(PersonalInfo p){
		personalDetails = p;
	}
	
	public String getFirst(){
		return firstName;
	}

	public String getLast(){
		return lastName;
	}
	
	public int getID(){
		return ID;
	}
	
	public Contact getContact(){
		return contact;
	}
	
	public PersonalInfo getPersonalDetails(){
		return personalDetails;
	}
	
}// end of class Person

class Patient extends Person {
	
	private int doctor;
	private ContactAddress address;
	
	public Patient(String f, String l, int id, int doc, PersonalInfo p, ContactAddress c){
		super(f,l,id,p,c);
		doctor = doc;
		address = c;
	}
	
	public void setDoc(int d){
		doctor = d;
	}
	
	public int getDoc(){
		return doctor;
	}
	
	public void setAddress(ContactAddress d){
		address = d;
		contact = address;
	}
	
	public ContactAddress getAddress(){
		return address;
	}
	
	
	
	@Override 
	public String toString(){
		return String.format("%s,%s,%d,%d,%s,%s", firstName, lastName, ID, doctor, personalDetails, contact );
	}	
	
}// end of class Patient

class Staff extends Person {
	
	private int dept;
	private String type;
	
	public Staff(String t, String f, String l, int id, int d, PersonalInfo p, Contact c){
		super(f,l,id,p,c);
		dept = d;
		type = t;
	}
	
	public void setDept(int d){
		dept = d;
	}
	
	public void setType(String t){
		type = t; 
	}
	
	public int getDept(){
		return dept;
	}
	
	public String getType(){
		return type;
	}
	
	@Override
	public String toString(){
		return String.format("%s,%s,%s,%d,%d,%s,%s",type,firstName,lastName,ID,dept,personalDetails,contact);
	}
	
}// end of class Staff












