package task1lv2OOPL8;

import java.util.Arrays;

public class Stack {
	private Object[] objects;

	public Object[] getObjects() {
		return objects;
	}

	public void setObjects(Object[] objects) {
		this.objects = objects;
	}

	@Override
	public String toString() {
		return "Stack [objects=" + Arrays.toString(objects) + "]";
	}

	public void push(Object obj) {
		if (objects == null) {
			objects = new Object[] { obj };
		} else {
			int length = objects.length;
			Object[] newObjects = Arrays.copyOf(objects, length + 1);
			newObjects[length] = obj;
			objects = newObjects;
		}
	}
	
	public Object pop() {
		Object result;
		int length = objects.length;
		result = objects[length - 1];
		objects = Arrays.copyOf(objects, length - 1);
		return result;
	
	}
	
	public Object peek() {
		return objects[objects.length - 1];
	}

}
