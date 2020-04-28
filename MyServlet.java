package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mult")
public class MyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String newValue = request.getParameter("value");
        if (newValue == null || newValue.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            boolean flag = newValue.chars().allMatch(n -> Character.isLetter(n));
            if (flag) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.sendError(400);
            } else {
                response.setStatus(HttpServletResponse.SC_OK);
                int result = Integer.parseInt(newValue) * 2;
                response.getWriter().println(result);
                response.setContentType("text/html;charset=utf-8");
            }
        }
    }
}
