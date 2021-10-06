package task1OOPL4;

import java.util.Scanner;

import task1OOPL4.exeptions.WrongGenderExeption;

public class CreateStudent {
	private Scanner sc = new Scanner(System.in);

	public CreateStudent() {
		super();
	}

	public Student createStudentFromKeyboard() throws WrongGenderExeption {
		String name;
		String surname;
		String gender;
		int age;
		int id;
		
		
		System.out.println("Input a name of new student");
		name = sc.nextLine();

		System.out.println("Input a surname of new student");
		surname = sc.nextLine();
		
		System.out.println("Input a gender of new student: MALE or FEMALE");
		gender = sc.nextLine();

		System.out.println("Input an age of new student");
		age = sc.nextInt();


		System.out.println("Input an id of new student");
		id = sc.nextInt();
		
		try {
			return new Student(name, surname, age, Gender.valueOf(gender), id);
		} catch (IllegalArgumentException e) {
			throw new WrongGenderExeption(); 
		}
	}

}
