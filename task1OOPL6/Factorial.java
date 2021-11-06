package task1OOPL6;

import java.math.BigInteger;

public class Factorial implements Runnable{
	private int number;
	private BigInteger fact;
	public Factorial(int number) {
		super();
		this.number = number;
		fact = BigInteger.ONE;
	}
		
		
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}



	public BigInteger getFact() {
		return fact;
	}



	public void setFact(BigInteger fact) {
		this.fact = fact;
	}



	@Override
	public void run() {
		for (int i = 1; i <= number; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		System.out.println("Factorial of " + number + " = " + fact);
		
	}
	
	
	
	

}
