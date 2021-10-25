package task2OOPL9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import task2OOPL9.exeptions.StudentNotFoundExeption;
import task2OOPL9.exeptions.TheGroupIsOvercrowdedExeption;
import task2OOPL9.exeptions.TheStudentIsAlreadyinTheGroupExeption;

public class Group {
	private List<Student> students = new ArrayList<>(10);
	private String name;

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group() {
		super();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
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
		return "Group [students=" + students + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, students);
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
		return Objects.equals(name, other.name) && Objects.equals(students, other.students);
	}

	public void addStudent(Student student)
			throws TheStudentIsAlreadyinTheGroupExeption, TheGroupIsOvercrowdedExeption {

		if (eqalsStudentsInGroup(student)) {
			throw new TheStudentIsAlreadyinTheGroupExeption();
		}

		if (students.size() >= 10) {
			throw new TheGroupIsOvercrowdedExeption();
		}
		if (!students.add(student)) {
			throw new TheGroupIsOvercrowdedExeption();
		}
	}

	public void deleteStudent(int id) throws StudentNotFoundExeption {

		Student studentToDelete = searhStudentById(id);
		students.remove(studentToDelete);

	}

	public Student searhStudentBySurname(String surname) throws StudentNotFoundExeption {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getSurname().equals(surname)) {
				return students.get(i);
			}
		}
		throw new StudentNotFoundExeption();

	}

	public Student searhStudentById(int id) throws StudentNotFoundExeption {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				return students.get(i);
			}
		}
		throw new StudentNotFoundExeption();

	}

	public List<Student> sortStudentsByLastName(List<Student> students) {
		StudentSurnameComparator compartor = new StudentSurnameComparator();
		students.sort(compartor);
		return students;

	}

	public boolean eqalsStudentsInGroup(Student studentCheck) {
		if (studentCheck == null) {
			return false;
		}
		for (Student student : students) {
			if (student != null && student.equals(studentCheck)) {
				return true;
			}
		}
		return false;

	}

}
