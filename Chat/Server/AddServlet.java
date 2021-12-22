package ua.kiev.prog;

import jakarta.servlet.http.*;
import ua.kiev.prog.exeptions.UserNotFoundException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static ua.kiev.prog.MessageList.getInstance;

public class AddServlet extends HttpServlet {

	private MessageList msgList = getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		byte[] buf = requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

		Message msg = Message.fromJSON(bufStr);
		if (msg != null) {
            try {
                msgList.add(isPrivateMess(msg));
            } catch (UserNotFoundException e) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
		else
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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

    private Message isPrivateMess (Message msg) throws UserNotFoundException {
        if (msg.getTo() == null){
            return msg;
        }
        UserList userList = UserList.getInstance();
        if (userList.checkByLogin(msg.getTo())){
            return msg;
           }
        else {
            throw new UserNotFoundException();
        }
    }
}
