package task1lv2OOPL8;

public class Main {

	public static void main(String[] args) {
		Integer int1 = 11;
		Integer int2 = 22;
		String str1 = "Test1";
		String str2 = "Test2";
		
		 Stack stack= new Stack();
		 
		 stack.push(int1);
		 System.out.println(stack);
		 stack.push(int2);
		 System.out.println(stack);
		 stack.push(str1);
		 System.out.println(stack);
		 System.out.println(stack.pop());
		 System.out.println(stack);
		 System.out.println(stack.peek());
		 System.out.println(stack);
	}

}
