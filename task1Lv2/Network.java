package task1Lv2;


import java.util.ArrayList;

public class Network {

		private static ArrayList registeredNumbers = new ArrayList();

		public Network(ArrayList registeredNumbers) {
			super();
			this.registeredNumbers = registeredNumbers;
		}

		public Network() {
			super();
		}

		public ArrayList getRegisteredNumbers() {
			return registeredNumbers;
		}

		public  void setRegisteredNumbers(ArrayList registeredNumbers) {
			this.registeredNumbers = registeredNumbers;
		}

		public static boolean registration(int newNum) {
			registeredNumbers.add(newNum);
			return true;
			
		}
		
		public static boolean searhNum(int num) {
			for (int i = 0; i < registeredNumbers.size(); i++) {
				if (registeredNumbers.get(i).equals(num)) {
					return true;
				}
			}
			return false;
			
			
		}
		
}
