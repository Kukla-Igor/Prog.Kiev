package ua.kiev.prog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
		Class<?> cls = TestMethod.class;
		Test test = cls.getAnnotation(Test.class);
		Method[] methods = cls.getDeclaredMethods();

		for (Method method : methods){
			System.out.println(method.getName());
				method.invoke(null, test.a(), test.b());
			}
		}
	}

@Test(a = 2, b = 5)
class TestMethod {
	public static void test(int a, int b) {
		System.out.println(a);
		System.out.println(b);
	}
}
