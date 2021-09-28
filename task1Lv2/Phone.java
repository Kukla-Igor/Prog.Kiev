package task1Lv2;

public class Phone {
	private int num;
	private Network net;

	public Phone(int num) {
		super();
		this.num = num;
	}

	public Phone() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Network getNet() {
		return net;
	}

	public void setNet(Network net) {
		this.net = net;
	}

	public String toString() {
		return "Phone [num=" + num + ", regis=" + net + "]";
	}

	public void registration(Network net) {
		this.net = net;
		if (net.searhPhoneByNum(this.num) == null) {
			net.register(this);
		}

	}

	public void outgoingCall(int toCallNum) {
		if (net == null || net.searhPhoneByNum(this.num) == null) {
			System.out.println("Your number was not registered on the network");
			return;
		} else if (net.searhPhoneByNum(toCallNum) == null) {
			System.out.println("The number you are calling has not been registered in the network");
			return;
		}

		Phone phoneTo = net.searhPhoneByNum(toCallNum);
		phoneTo.incoming—all(this.num);
	}

	public void incoming—all(int incomingNum) {

		System.out.println("Subscriber " + this.num + ", subscriber " + incomingNum + " calls you");
	}
}
