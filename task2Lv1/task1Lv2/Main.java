package task1Lv2;

public class Main {

	public static void main(String[] args) {
		Phone phone1 = new Phone(11111111);
		Phone phone2 = new Phone(22222222);
		
		phone1.outgoingCall(phone2.getNum());
		phone2.outgoingCall(phone1.getNum());
		
		phone1.registration();
		
		phone1.outgoingCall(phone2.getNum());
		phone2.outgoingCall(phone1.getNum());
		
		phone2.registration();
		
		phone1.outgoingCall(phone2.getNum());
		phone2.outgoingCall(phone1.getNum());


	}

}
