package ua.kiev.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			int res;
			User user = new User();

			while (true) {
				System.out.println("Are you a new client? [Y/N]");
				String answer = scanner.nextLine();
				System.out.println("Enter your login: ");
				String login = scanner.nextLine();
				user.setLogin(login);
				System.out.println("Enter your password: ");
				String pass = scanner.nextLine();
				user.setPass(pass);


				if (answer.equals("N") || answer.equals("n")) {
					res = user.send(Utils.getURL() + "/login");
					if (res == 200){
						break;
					} else {
						System.out.println("HTTP error occured: " + res);
						return;
					}
				}else if (answer.equals("Y") || answer.equals("y")) {
					res = user.send(Utils.getURL() + "/addUser");
					if (res == 200){
						break;
					} else {
						System.out.println("HTTP error occured: " + res);
						return;
					}
				} else {
					System.out.println("Try again or press E to exit");
					answer = scanner.nextLine();
					if (answer.equals("E") || answer.equals("e")){
						return;
					}
				}

			}



			Thread th = new Thread(new GetThread(user.getLogin()));
			th.setDaemon(true);
			th.start();


			while (true) {
				System.out.println("Enter your message or SELECT user to write a private message or ONLINE to get online users: ");
				String text = scanner.nextLine();
				if (text.isEmpty()) {
					res = user.send(Utils.getURL() + "/logout");
					break;
				} else if(text.equals("SELECT")){
					System.out.println("Enter the user`s login to write him a private message: ");
					String loginTo = scanner.nextLine();
					System.out.println("Enter your private message: ");
					String privateText = scanner.nextLine();
					Message privateMess = new Message(user.getLogin(), loginTo, privateText);
					res = privateMess.send(Utils.getURL() + "/add");
					if (res != 200){
						System.out.println("HTTP error occured: " + res);
						return;
					}

				} else if(text.equals("ONLINE")){
					user.getOnline();


				} else {

					Message m = new Message(user.getLogin(), text);
					res = m.send(Utils.getURL() + "/add");
					if (res != 200) { // 200 OK
						System.out.println("HTTP error occured: " + res);
						return;
					}
				}

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}


}
