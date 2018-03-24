package hospital;

public class Department {

	private int ID;
	private String deptName;
	
	public Department(String d, int id){
		deptName = d;
		ID = id;
	}
	
	public void setID(int id){
		
		ID = id;
	}
	
	public void setDeptName(String d){
		deptName = d;
	}
	
	public int getID(){
		return ID;
	}
	
	public String getDeptName(){
		return deptName;
	}
	
	@Override
	public String toString(){
		return String.format("%s,%d", deptName,ID);
	}
	
	
}// end of class




	
	

