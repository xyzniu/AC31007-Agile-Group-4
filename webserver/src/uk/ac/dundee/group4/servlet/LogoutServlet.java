package uk.ac.dundee.group4.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is a Servlet dealing with user logout.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    /**
     * User logout.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // invalidate the session
        HttpSession session = request.getSession();
        session.invalidate();
        // redirect to login page
        response.sendRedirect("index.jsp");
    }
}
