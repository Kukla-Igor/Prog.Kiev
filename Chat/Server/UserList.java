package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;
import java.util.List;

public class UserList {
	private static final UserList userList = new UserList();

	private final Gson gson;
	private final List<User> list = new LinkedList<>();

	public static UserList getInstance() {
		return userList;
	}

	private UserList() {
		gson = new GsonBuilder().create();
	}

	public synchronized void add(User user) {
		list.add(user);
	}

	public boolean check(User user) {
		return list.contains(user);
	}

	public boolean checkByLogin(String login) {
		for (User user : list) {
			if (user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

	public void changeStatus(User user) {
		int index = list.indexOf(user);
		user.setStatus(false);
		list.set(index, user);
//		list.remove(user);
//		user.setStatus(false);
//		list.add(user);
	}


	public synchronized String onlineToJSON() {
		int i = 1;
		List<String> timeList = new LinkedList<>();
		for (User user: list) {
			if (user.isStatus()){
				timeList.add("User №" + i++ + " " + user.getLogin());
			}

		}
		return gson.toJson(new JsonString(timeList));
	}

}
