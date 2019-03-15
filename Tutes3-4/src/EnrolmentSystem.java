
public class EnrolmentSystem {

	public static void main(String[] args) {
		Student stud1 = new Student("paul", 1001 );
		Course COSC = new Course("Maths", 101);
		Student stud2 = new Student("Anna", 2001);
		Course COPG = new Course("Prog", 202);
		COPG.addStud(stud1);
		
		
//System.out.println(stud1.getStudID());
System.out.println(stud1.toString());
System.out.println(COSC.toString());
System.out.println(COPG.toString());

	}

}
