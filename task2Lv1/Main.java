package task2Lv1;

public class Main {

	public static void main(String[] args) {
		Triangle tri1 = new Triangle(3.7, 4.25, 5.79);

		System.out.println(tri1.getArea());

		Triangle tri2 = new Triangle();
		
		tri2.setA(7.9);
		tri2.setB(10.5);
		tri2.setC(1.9);
		
		System.out.println(tri2.getArea());
		
	}

}
