package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.service.DeleteCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCommentServlet", value = "DeleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
    DeleteCommentService deleteCommentService = new DeleteCommentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_id = request.getParameter("comment_id");
        String comment = request.getParameter("comment");
        System.out.println("post");
        System.out.println(comment_id);
        System.out.println(comment);
        deleteCommentService.deleteComment(comment_id);
        request.getRequestDispatcher("deleteComment.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
