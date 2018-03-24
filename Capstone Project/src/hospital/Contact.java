package hospital;
////////////////////////Contact.java includes classes Contact and ContactAddress
public class Contact {
	
	private String email, phone;
	
	public Contact(String p, String e){
		phone = p;
		email = e;
	}
	
	public void setEmail(String e){
		email = e;
	}
	
	public void setPhone(String p){
		phone = p;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String toString(){
		return String.format("%s,%s", phone, email);
	}
}// end of class Contact

	class ContactAddress extends Contact{//I used ContactAddress as the name rather than just Address is because 
									///////I want it to inherit from Contact to do my polymorphic call; for practice
		private int no;
		private String street, city, state, zip;
		
		public ContactAddress(int n, String s, String c, String st, String z, String p, String e){
			super(p,e);
			no = n;
			street = s;
			city = c;
			state = st;
			zip = z;
		}
		
		public void setNo(int n){
			no = n;
		}
		
		public int getNo(){
			return no;
		}
		
		public void setStreet(String s){
			street = s;
		}
		
		public String getStreet(){
			return street;
		}
		
		public void setCity(String c){
			city = c;
		}
		
		public String getCity(){
			return city;
		}
		
		public void setState(String s){
			state = s;
		}
		
		public String getState(){
			return state;
		}
		
		public void setZip(String z){
			zip = z;
		}
		
		public String getZip(){
			return zip;
		}
		
		@Override // overriding superclass Contact toString()
		public String toString(){
			return String.format("%d,%s,%s,%s,%s,%s",no,street,city,state,zip,super.toString() );
		}
		
	}// end of Class ContactAddress


