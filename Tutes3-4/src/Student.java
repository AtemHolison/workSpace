
public class Student {

	private String studName;
	private int studID;
	
	
	public Student(String studName, int studID) {
		this.studName = studName;
		this.studID = studID;	
	}
	
	public String getStudName() {
		return studName;
	}
	
	public int getStudID() {
		return studID;
	}
	
	public String toString() {
		return String.format("Student Name : %s\nStudent ID : %d ", this.studName, this.studID);
	}
	

	}


