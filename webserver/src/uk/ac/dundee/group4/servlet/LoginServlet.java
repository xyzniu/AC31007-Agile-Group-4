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
 * This is a Servlet dealing with user login.
 * <p>
 * Redirect to login page if username or password are wrong.
 */
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    /**
     * Get user info from request.
     * Check whether user is exists in the database.
     * If user exists, package it in http session.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("staff");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User u = userService.selectByUsernamePasswordAndType(username, password, option);

        if (u == null) {
            // no such user
            request.setAttribute("errorMsg", "Wrong username or password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            // user exists
            // add it in http session
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            System.out.println(u);
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
