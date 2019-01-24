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
        String comment = request.getParameter("comment");
        String exam_paper_id = request.getParameter("exam_paper_id");
        String user_id = request.getParameter("user_id");
        String staff_type = request.getParameter("staff_type");
        insertCommentService.insertComment(comment, exam_paper_id, user_id, staff_type);
        request.getRequestDispatcher("SelectCommentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
