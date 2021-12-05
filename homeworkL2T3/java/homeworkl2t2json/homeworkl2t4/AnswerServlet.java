package homeworkl2t2json.homeworkl2t4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "answer", value = "/answer")
public class AnswerServlet extends HttpServlet {
    private String textHTML =  "<html>" +
            "<head><title>Prog.kiev.ua</title></head>" +
            "<body><h1>Your age is %s</h1>" +
            "<h1>You are from %s</h1>" +
            "</body></html>";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String param1 = request.getParameter("age");
        String param2 = request.getParameter("city");
        response.getWriter().println(String.format(textHTML, param1, param2));
    }


}
