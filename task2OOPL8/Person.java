package task2OOPL8;

import java.util.Objects;

public abstract class Person {
	private String name;
	private String surname;
	private int age;
	private Gender gender;

	public Person(String name, String surname, int age, Gender gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname);
	}

	
}
