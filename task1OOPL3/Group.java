package task1OOPL3;

import java.util.Arrays;
import task1OOPL3.exeptions.StudentNotFoundExeption;
import task1OOPL3.exeptions.TheGroupIsOvercrowdedExeption;
import task1OOPL3.exeptions.TheStudentIsAlreadyinTheGroupExeption;

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
		Student tempValue;
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = i; j < students.length - 1; j++) {
				if (students[j] == null) {
					tempValue = students[j];
					students[j] = students[j + 1];
					students[j + 1] = tempValue;
				}
			}
		}

		for (int i = 0; i < students.length - 1; i++) {
			for (int j = i; j < students.length - 1; j++) {
				if (students[j + 1] == null) {
					break;
				} else if (students[i].getSurname().compareTo(students[j + 1].getSurname()) > 0) {
					tempValue = students[i];
					students[i] = students[j + 1];
					students[j + 1] = tempValue;
				}
			}
		}

		return "Group [students=" + Arrays.toString(students) + ", name=" + name + "]";
	}

	public void addStudent(Student student)
			throws TheStudentIsAlreadyinTheGroupExeption, TheGroupIsOvercrowdedExeption {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				student.setGroup(this.name);
				students[i] = student;
				return;
			} else if (students[i] == student) {
				throw new TheStudentIsAlreadyinTheGroupExeption();
			}
		}
		throw new task1OOPL3.exeptions.TheGroupIsOvercrowdedExeption();

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
}
