package ua.kiev.prog;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class LogoutServlet extends HttpServlet {

	private UserList userList = UserList.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		byte[] buf = requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

		User user = User.fromJSON(bufStr);
		if (userList.check(user)){
            userList.changeStatus(user);
            resp.setStatus(HttpServletResponse.SC_OK);
//            HttpSession session = req.getSession(true);
//            session.setAttribute("user_login", user.getLogin());
        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

	}

	private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
