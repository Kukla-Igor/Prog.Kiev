package task2OOPL6;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[200000010];

		long sumSimple;
		long sumMulti;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100);
		}

		sumSimple = SimpleSum(arr);
		System.out.println("The sum of array by simple method = " + sumSimple);

		sumMulti = multiSum(arr);
		System.out.println("The sum of array by multi method = " + sumMulti);

	}

	public static long SimpleSum(int[] arr) {
		long beginTime;
		long endTime;
		long sum = 0;
		beginTime = new Date().getTime();
		for (int i : arr) {
			sum += i;
		}
		endTime = new Date().getTime();
		System.out.println("Runtime by simple method = " + (endTime - beginTime));
		return sum;
	}

	public static long multiSum(int[] arr) {
		long beginTime;
		long endTime;
		int cpu = Runtime.getRuntime().availableProcessors();
		int step = arr.length / cpu;
		int begin = 0;
		int end = step;
		long sum = 0;
		int remainder = arr.length % cpu;
		long sumByRem = 0; 

		MultiSum[] milMultiSumArr = new MultiSum[cpu];
		Thread[] threads = new Thread[cpu];

		for (int i = 0; i < cpu; i++) {
			milMultiSumArr[i] = new MultiSum(begin, end, arr);
			threads[i] = new Thread(milMultiSumArr[i]);
			begin = end;
			end += step;
		}

		beginTime = new Date().getTime();

		for (int i = 0; i < cpu; i++) {
			threads[i].start();
		}
		if (remainder != 0) {
			MultiSum ms = new MultiSum(step * cpu, arr.length, arr);
			Thread thrByRem = new Thread(ms);
			thrByRem.start();
			try {
				thrByRem.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sumByRem = ms.getSum();
		}

		try {
			for (int i = 0; i < cpu; i++) {
				threads[i].join();
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		


		for (int i = 0; i < cpu; i++) {
			sum += milMultiSumArr[i].getSum();
		}

		endTime = new Date().getTime();
		System.out.println("Runtime by multi method = " + (endTime - beginTime));
		return sum + sumByRem;

	}

}
