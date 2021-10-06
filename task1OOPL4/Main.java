package task1OOPL4;

import task1OOPL4.exeptions.StudentNotFoundExeption;
import task1OOPL4.exeptions.TheGroupIsOvercrowdedExeption;
import task1OOPL4.exeptions.TheStudentIsAlreadyinTheGroupExeption;
import task1OOPL4.exeptions.WrongGenderExeption;;

public class Main {

	public static void main(String[] args) {
		Group group = new Group("TheBest");

		Student ivan = new Student("Ivan", "Kirilov", 21, Gender.MALE, 0);
		Student petr = new Student("Petr", "Petrov", 21, Gender.MALE, 1);
		Student ann = new Student("Anna", "Annovina", 21, Gender.FEMALE, 2);
		Student serg = new Student("Sergey", "Ivanov", 20, Gender.MALE, 3);
		Student dima = new Student("Dmitriy", "Bogdanov", 20, Gender.MALE, 4);
		Student kate = new Student("Katerina", "Dubova", 21, Gender.FEMALE, 5);
		Student olya = new Student("Olga", "Serdykova", 20, Gender.FEMALE, 6);
		Student mary = new Student("Marina", "Loshkina", 21, Gender.FEMALE, 7);
		Student bogdan = new Student("Bogdan", "Dmitriev", 20, Gender.MALE, 8);
		Student victor = new Student("Victor", "Pobedov", 20, Gender.MALE, 9);
		Student alex = new Student("Alexandra", "Kirova", 20, Gender.FEMALE, 10);

		try {
			group.addStudent(ivan);
			group.addStudent(petr);
			group.addStudent(ann);
			group.addStudent(serg);
			group.addStudent(dima);
			group.addStudent(kate);
			group.addStudent(olya);
			group.addStudent(mary);
			group.addStudent(bogdan);
			group.addStudent(victor);

			group.deleteStudent(0);
			group.deleteStudent(5);

			// System.out.println(group.searhStudent("Dubova").toString());

		} catch (TheGroupIsOvercrowdedExeption | TheStudentIsAlreadyinTheGroupExeption | StudentNotFoundExeption e) {
			// System.out.println(e.getMessage());
		}

		CreateStudent cs = new CreateStudent();

		//try {
		//	Student newStudent = cs.createStudentFromKeyboard();
		//	System.out.println(newStudent.toString());
		//} catch (WrongGenderExeption e) {
		//	System.out.println(e.getMessage());
		//}

		ivan.setGroup("55");
		String str = ivan.toCSVString();
		System.out.println(str);
		
		
		petr = ivan.fromCSVString(str);
		System.out.println(petr.toString());
	}

}
