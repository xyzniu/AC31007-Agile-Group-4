package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.UserService;
import uk.ac.dundee.group4.util.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login servlet for dealing with login things.
 *
 * Redirect to login page if username or password is wrong.
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("staff");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = userService.selectByUsernamePasswordAndType(username, password, option);

        if (u == null) {
            request.setAttribute("errorMsg", "Wrong username or password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            System.out.println(u);
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
