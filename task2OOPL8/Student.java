package task2OOPL8;

import java.util.Objects;

public class Student extends Person implements CSVConverter {
	private int id;
	private String group;

	public Student(String name, String surname, int age, Gender gender, int id) {
		super(name, surname, age, gender);
		this.id = id;
	}

	public Student(String name, String surname, int age, Gender gender) {
		super(name, surname, age, gender);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", group=" + group + " " + super.toString() + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(group, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(group, other.group) && id == other.id;
	}

	@Override
	public String toCSVString() {
		String delim = ";";
		return this.getName() + delim + this.getSurname() + delim + this.getAge() + delim + this.getGender() + delim
				+ id + delim + group;

	}

	@Override
	public Student fromCSVString(String str) {
		String[] arr = str.split(";");
		String name = arr[0];
		String surname = arr[1];
		int age = Integer.parseInt(arr[2]);
		Gender gender = Gender.valueOf(arr[3]);
		int id = Integer.parseInt(arr[4]);
		String group = arr[5];

		Student student = new Student(name, surname, age, gender, id);
		student.setGroup(group);
		
		return student;

	}

}
