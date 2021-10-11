package task2OOPL5;

import java.util.Arrays;

import task2OOPL5.exeptions.StudentNotFoundExeption;
import task2OOPL5.exeptions.TheGroupIsOvercrowdedExeption;
import task2OOPL5.exeptions.TheStudentIsAlreadyinTheGroupExeption;

public class Group {
	private Student[] students = new Student[10];
	private String name;

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group [students=" + Arrays.toString(students) + ", name=" + name + "]";
	}

	public void addStudent(Student student)
			throws TheStudentIsAlreadyinTheGroupExeption, TheGroupIsOvercrowdedExeption {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				student.setGroup(this.name);
				students[i] = student;
				return;
			} else if (students[i].getId() == student.getId()) {
				throw new TheStudentIsAlreadyinTheGroupExeption();
			}
		}
		throw new task2OOPL5.exeptions.TheGroupIsOvercrowdedExeption();

	}

	public void deleteStudent(int id) throws StudentNotFoundExeption {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getId() == id) {
				students[i].setGroup(null);
				students[i] = null;
				return;
			}

		}
		throw new StudentNotFoundExeption();
	}

	public Student searhStudent(String surname) throws StudentNotFoundExeption {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getSurname() == surname) {
				return students[i];
			}

		}
		throw new StudentNotFoundExeption();

	}
	
	public Student[] sortStudentsByLastName(Student[] students) {
		 Arrays.sort(students, new StudentSurnameComparator());
		 return students;
		
	}
}
