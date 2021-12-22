package ua.kiev.prog;

import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {
	private static final MessageList msgList = new MessageList();

    private final Gson gson;
	private final List<Message> list = new LinkedList<>();
	
	public static MessageList getInstance() {
		return msgList;
	}
  
  	private MessageList() {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}
	
	public synchronized void add(Message m) {
		list.add(m);
	}
	
	public synchronized String toJSON(int n, String login) {
		if (n >= list.size()) {
			return null;
		}
		List<Message> timeList = new LinkedList<>();
		for (Message message: list) {
			if (message.getTo() == null || message.getTo().equals(login)){
				timeList.add(message);
			}

		}
		return gson.toJson(new JsonMessages(timeList, n));
	}
}
