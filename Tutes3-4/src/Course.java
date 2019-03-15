
public class Course {

	private String courseName;
	private int courseID;
	private Student[] enrolStud;
	private final int maxStuds = 5;
	private int currStud;

	public Course(String courseName, int courseID) {

		this.courseName = courseName;
		this.courseID = courseID;

		this.enrolStud = new Student[maxStuds];
	}

	public String getCourseName() {
		return courseName;
	}

	public int getCourseID() {
		return courseID;
	}

	public void addStud(Student newStud) {
		this.enrolStud[this.currStud] = newStud;
		this.currStud++;
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < currStud; i++) {
			temp += this.enrolStud[i].toString();

		}
		return String.format("Course Name : %s\n Course ID : %d\n Students are : %s", this.courseName, this.courseID,
				temp);
	}

}
