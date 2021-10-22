package task2OOPL8;

import java.util.Arrays;
import java.util.Objects;

import task2OOPL8.exeptions.StudentNotFoundExeption;
import task2OOPL8.exeptions.TheGroupIsOvercrowdedExeption;
import task2OOPL8.exeptions.TheStudentIsAlreadyinTheGroupExeption;

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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(name, other.name) && Arrays.equals(students, other.students);
	}

	public void addStudent(Student student)
			throws TheStudentIsAlreadyinTheGroupExeption, TheGroupIsOvercrowdedExeption {
			if (eqalsStudentsInGroup(student)) {
				throw new TheStudentIsAlreadyinTheGroupExeption();
			}
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				student.setGroup(this.name);
				students[i] = student;
				return;
			} 
		}
		throw new TheGroupIsOvercrowdedExeption();

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
	
	public boolean eqalsStudentsInGroup(Student studentCheck) {
		if(studentCheck == null) {
			return false;
		}
		for (Student student : students) {
			if (student!= null && student.equals(studentCheck)) {
				return true;
			}
		}
		return false;
		
	}

}
