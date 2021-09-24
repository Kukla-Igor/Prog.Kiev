package task1Lv1;

public class Main {

	public static void main(String[] args) {
		Product prod1 = new Product(25.2, "Some product #1", 0.8);
		
		System.out.println(prod1.getDescription());
		System.out.println(prod1.getPrice());
		System.out.println(prod1.getWeight());;

		Product prod2 = new Product();
		
		prod2.setDescription("Some product #2");
		prod2.setPrice(9.99);
		prod2.setWeight(1.5);
		
		System.out.println(prod2.toString());
	}

}
