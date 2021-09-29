package task1Lv1OOPL2;

public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog("Pedigree", "White", 10, "Wolf");
		Cat cat = new Cat("Whiskas", "Black", 3, "Tiger");
		Veterinarian vet = new Veterinarian("Inna");
		
		dog.eat();
		dog.sleep();
		System.out.println(dog.getVoice());
		
		cat.eat();
		cat.sleep();
		System.out.println(cat.getVoice());
		
		
		vet.treatment(cat);
		vet.treatment(dog);
		
	}

}

