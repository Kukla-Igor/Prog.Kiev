package task1OOPL6;

public class Main {

	public static void main(String[] args) {
		Factorial[] factorialArr = new Factorial[100];
		Thread[] threadArr = new Thread[100];
		
		for (int i = 0; i < factorialArr.length; i++) {
			factorialArr[i] = new Factorial(i);
			threadArr[i] = new Thread(factorialArr[i]);
			threadArr[i].start();
		}
		
		System.out.println("Main ends");
		
		
	}

}
