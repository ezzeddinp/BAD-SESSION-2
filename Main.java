public class Main{
	static Scanner sc = new Scanner(System.in);
	ArrayList<StudentDatabase> studentLists = new ArrayList<>(); // call the database class

	
	public Main() {
		int input = 0;
		String studentName = null;
		int studentAge = 0;
		Double studentGpa = null;

		
		// student input their NAME
		System.out.println("Hello, Welcome to Student Dummy Data!");
		do {
			System.out.print("Input your name [3 - 15 char](cannot be change): ");
			studentName = sc.nextLine();
			if (studentName.length() <= 3 || studentName.length() >= 15) {
				System.out.println("\nInvalid input. Name must be 3 - 15 char!. Try again");
			}
		} while (studentName.length() <= 3 || studentName.length() >= 15);
		
		// Student input their AGE
		do {
			System.out.print("\nInput your age [min 16](cannot be change): ");
			studentAge = sc.nextInt(); sc.nextLine();
			if (studentAge <= 16) {
				System.out.println("\nInvalid input age. Min 16 years old. Try again");
			}
		} while (studentAge <= 16);
		
		// Student input their GPA
		do {
			System.out.print("\nInput your gpa [0.0 - 4.0 inclusive]: ");
			studentGpa = sc.nextDouble(); sc.nextLine();
			if (studentGpa <= 1 && studentGpa >= 4) {
				System.out.println("\nInvalid input Gpa. range [0.0]");
			}
		} while (studentGpa <= 1 && studentGpa >= 4);
		
		// saving student input
		studentLists.add(new StudentDatabase(studentName, studentAge, studentGpa));
		
		do {
			System.out.println("\nWelcome, " + studentName);
			System.out.println("Student Dummy Data");
			System.out.println("=================");
			System.out.println("1. View Data");
			System.out.println("2. Update Data");
			System.out.println("3. Exit");
			System.out.print(">> ");
			input = sc.nextInt(); sc.nextLine();
			
//			while(!sc.hasNextInt()) {
//				System.out.println("\nInvalid choos. Please choose between 1 - 4");
//				sc.next();
//				System.out.print(">> ");	
//			}
			
			switch (input) {
			case 1:
				viewData();
				break;
			case 2:
				updateData();
				break;
			default:
				break;
			}
			
		} while (input != 3);
	}

	private void viewData() {
		// TODO Auto-generated method stub
		if (studentLists.isEmpty()) {
			System.out.println("There is no order medicine history!");
			sc.nextLine();
		} else {
			for (StudentDatabase sd : studentLists) {
				System.out.println("Your Name is " + sd.studentName);
				System.out.println("Your Age is " + sd.studentAge);
				System.out.println("Your Gpa is " + sd.studentGpa);
			}
		}
	}

	private void updateData() {
        if (studentLists.isEmpty()) {
            System.out.println("No student data available to update!");
            return;
        }
        
        StudentDatabase student = studentLists.get(0);
        
        System.out.println("\nYour Name is " + student.studentName);
		System.out.println("Your Age is " + student.studentAge);
		System.out.println("Your Gpa is " + student.studentGpa);
		
		Double newGpa = null;
		do {
			System.out.print("Enter new GPA [0.0 - 4.0 inclusive]: ");
			newGpa = sc.nextDouble(); sc.nextLine();
			
			if (!student.setStudentGpa(newGpa)) {
				System.out.println("\nInvalid input. GPA must be between 0.0 and 4.0. Try again.");
			}
		} while (newGpa <= 0.0 && newGpa > 4.0);
		
		System.out.println("GPA successfully updated.");
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
