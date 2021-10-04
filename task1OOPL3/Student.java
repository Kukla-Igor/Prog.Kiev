package task1OOPL3;

public class Student extends Person {
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

}
