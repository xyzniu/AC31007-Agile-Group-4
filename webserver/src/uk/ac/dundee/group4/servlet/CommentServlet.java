package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.Comment;
import uk.ac.dundee.group4.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "CommentServlet")
public class CommentServlet extends HttpServlet {
    CommentService commentService = new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");
        //request.getRequestDispatcher("insertComments.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("comments_list", commentService.selectAll());

        request.getRequestDispatcher("showComments.jsp").forward(request, response);
    }

}
