package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.service.InsertCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertCommentServlet", value = "InsertCommentServlet")
public class InsertCommentServlet extends HttpServlet {
    InsertCommentService insertCommentService = new InsertCommentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");

        insertCommentService.insertComment(comment_id,comment);
        //request.getRequestDispatcher("insertComments.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");

        System.out.println(comment_id);
        System.out.println(comment);
        insertCommentService.insertComment(comment_id,comment);

        request.getRequestDispatcher("insertComment.jsp").forward(request, response);
    }

}
