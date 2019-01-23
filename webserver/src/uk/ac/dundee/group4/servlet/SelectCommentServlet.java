package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.service.SelectCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertCommentServlet", value = "InsertCommentServlet")
public class SelectCommentServlet extends HttpServlet {
    SelectCommentService selectCommentService = new SelectCommentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment_id = request.getParameter("comment_id");
        System.out.println("post");
        System.out.println(comment_id);
        request.setAttribute("comments_list", selectCommentService.selectComment(comment_id));
        request.getRequestDispatcher("showComments.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
