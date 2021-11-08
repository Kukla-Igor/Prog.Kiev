package task2OOPL6;

public class MultiSum implements Runnable {
	private int firstEl;
	private int lastEl;
	private int[] arr;
	private long sum;

	public MultiSum(int firstEl, int lastEl, int[] arr) {
		super();
		this.firstEl = firstEl;
		this.lastEl = lastEl;
		this.arr = arr;
		this.sum = 0;
	}

	public int getFirstEl() {
		return firstEl;
	}

	public void setFirstEl(int firstEl) {
		this.firstEl = firstEl;
	}

	public int getLastEl() {
		return lastEl;
	}

	public void setLastEl(int lastEl) {
		this.lastEl = lastEl;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for (int i = firstEl; i < lastEl; i++) {
			sum += arr[i];
		}

	}

}
