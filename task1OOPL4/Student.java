package task1OOPL4;

import task1OOPL4.exeptions.WrongGenderExeption;

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
