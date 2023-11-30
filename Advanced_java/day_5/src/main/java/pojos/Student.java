package pojos;

public class Student {
	private String firstName;
	private String lastName;
	private int marks;
	private Course selectedcCourse;
	private boolean admissionStatus;
	
	public Student(String firstName, String lastName, int marks, Course selectedcCourse) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
		this.selectedcCourse = selectedcCourse;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Course getSelectedcCourse() {
		return selectedcCourse;
	}

	public void setSelectedcCourse(Course selectedcCourse) {
		this.selectedcCourse = selectedcCourse;
	}

	public boolean isAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(boolean admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", marks=" + marks + ", selectedcCourse="
				+ selectedcCourse + ", admissionStatus=" + admissionStatus + "]";
	}
	
}
