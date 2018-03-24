package hospital;

public class PersonalInfo {
	
	private String bday;
	private String gender;
	
	public PersonalInfo(String b, String g){
		bday = b;
		gender = g;
	}
	
	public void setBday(String b){
		bday = b;
	}
	
	public void setGender(String g){
		gender = g;
	}
	
	public String getBday(){
		return bday;
	}
	
	public String getGender(){
		return gender;
	}

	@Override //overriding Object toString
	public String toString(){
		return String.format("%s,%s", bday,gender);
	}
}
