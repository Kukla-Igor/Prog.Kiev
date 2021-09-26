package task1Lv2;

public class Phone {
	int num;
	boolean regis;

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

	public boolean isRegis() {
		return regis;
	}

	public void setRegis(boolean regis) {
		this.regis = regis;
	}

	public String toString() {
		return "Phone [num=" + num + ", regis=" + regis + "]";
	}

    public boolean registration() {
    	if(Network.registration(this.num)) {
    		return regis = true;
    	} else {
    		return false;
    	}
    	
		
	}
    
    public void outgoingCall(int toCallNum) {
    	if (regis == false) {
    		System.out.println("Your number was not registered on the network");
    	} else if (!Network.searhNum(toCallNum)) {
    		System.out.println("The number you are calling has not been registered in the network");
    	} else {
    		incoming—all(toCallNum);
    	}
    	
    	
    	
    	}
    
    public void incoming—all(int toCallNum) {
		System.out.println("Subscriber " + toCallNum + ", subscriber " + this.num + " calls you");
	}
}
