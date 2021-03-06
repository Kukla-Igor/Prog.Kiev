package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

public class User {
	private String login;
	private String pass;
	private boolean status;

	public User(String login, String pass) {
		this.login = login;
		this.pass = pass;

	}

	public User() {
	}

	public String toJSON() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(this);
	}
	
//	public static User fromJSON(String s) {
//		Gson gson = new GsonBuilder().create();
//		return gson.fromJson(s, User.class);
//	}


	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", pass='" + pass + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (login != null ? !login.equals(user.login) : user.login != null) return false;
		return pass != null ? pass.equals(user.pass) : user.pass == null;
	}

	@Override
	public int hashCode() {
		int result = login != null ? login.hashCode() : 0;
		result = 31 * result + (pass != null ? pass.hashCode() : 0);
		return result;
	}


	public int send(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		try (OutputStream os = conn.getOutputStream()) {
			String json = toJSON();
			os.write(json.getBytes(StandardCharsets.UTF_8));
			return conn.getResponseCode();
		}
	}

		public void getOnline() throws IOException {

			URL url = new URL(Utils.getURL() + "/online");
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.setDoOutput(true);

			Gson gson = new GsonBuilder().create();
			InputStream is = http.getInputStream();
			try {
				byte[] buf = responseBodyToArray(is);
				String strBuf = new String(buf, StandardCharsets.UTF_8);

				JsonString list = gson.fromJson(strBuf, JsonString.class);
				if (list != null) {
					for (String str : list.getList()) {
						System.out.println(str);
					}
				}
			} finally {
				is.close();
			}
		}

	private byte[] responseBodyToArray(InputStream is) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[10240];
		int r;

		do {
			r = is.read(buf);
			if (r > 0) bos.write(buf, 0, r);
		} while (r != -1);

		return bos.toByteArray();
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
