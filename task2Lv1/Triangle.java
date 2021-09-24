package task2Lv1;

public class Triangle {
	double a;
	double b;
	double c;

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	public double getArea() {
		if (a < b + c && b < a + c && c < a + b) {
			double p = (a + b + c) / 2.0;
			return Math.sqrt(p * (p - a) * (p - b) * (p - c));
		} else {
			System.out.println("Triangle does not exist");
			return -1;
		}

	}

}
