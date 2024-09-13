package sesi1oopjava;

// Constructor aka bluprint
public class StudentDatabase {
	String studentName;
	int studentAge;
	Double studentGpa;
	
	public StudentDatabase(String studentName, int studentAge, Double studentGpa){
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentGpa = studentGpa;
	}
	
	public boolean setStudentGpa(Double newGpa) {
		if (newGpa >= 0.0 && newGpa <= 4.0) {
			this.studentGpa = newGpa;
			return true;
		}
		return false;
	}

}
