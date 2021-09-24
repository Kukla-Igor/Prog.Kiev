package task1Lv2;

public class Network {

	public static void main(String[] args) {
		Phone phone1 = new Phone(11111111);
		Phone phone2 = new Phone(22222222);
		
		phone1.outgoingCall(phone2);
		phone2.outgoingCall(phone1);
		
		phone1.Registration();
		
		phone1.outgoingCall(phone2);
		phone2.outgoingCall(phone1);
		
		phone2.Registration();
		
		phone1.outgoingCall(phone2);
		phone2.outgoingCall(phone1);

	}

}
