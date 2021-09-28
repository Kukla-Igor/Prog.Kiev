package task1Lv2;

import java.util.Arrays;

public class Network {

	private Phone[] registeredPhones = new Phone[10];

	public Network(Phone[] registeredPhones) {
		super();
		this.registeredPhones = registeredPhones;
	}

	public Network() {
		super();
	}

	public Phone[] getRegisteredPhones() {
		return registeredPhones;
	}

	public void setRegisteredPhones(Phone[] registeredPhones) {
		this.registeredPhones = registeredPhones;
	}

	@Override
	public String toString() {
		return "Network [registeredPhones=" + Arrays.toString(registeredPhones) + "]";
	}

	public Phone searhPhoneByNum(int num) {
		for (int i = 0; i < registeredPhones.length; i++) {
			if (registeredPhones[i] == null) {
				return null;
			} else if (registeredPhones[i].getNum() == num) {
				return registeredPhones[i];
			}
		}

		return null;

	}

	public void register(Phone phone) {
		for (int i = 0; i < registeredPhones.length; i++) {
			if (registeredPhones[i] == null) {
				registeredPhones[i] = phone;
				System.out.println("Number " + phone.getNum() + " is registered");
				return;
			}
		}
	}

}
