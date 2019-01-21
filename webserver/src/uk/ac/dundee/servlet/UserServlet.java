package uk.ac.dundee.servlet;

import uk.ac.dundee.pojo.User;
import uk.ac.dundee.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", value = "UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "andy", "andy"));
        userList.add(new User(2, "jimi", "jimi"));
        request.setAttribute("users", userList);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
