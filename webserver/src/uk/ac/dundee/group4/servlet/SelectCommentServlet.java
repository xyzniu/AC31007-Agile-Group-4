package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.service.SelectCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelectCommentServlet", value = "SelectCommentServlet")
public class SelectCommentServlet extends HttpServlet {
    SelectCommentService selectCommentService = new SelectCommentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String exam_paper_id = request.getParameter("exam_paper_id");
        System.out.println("post");
        System.out.println(exam_paper_id);
        request.setAttribute("comments_list", selectCommentService.selectComment(exam_paper_id));
        request.getRequestDispatcher("showComments.jsp").forward(request, response);
=======
        doGet(request, response);
>>>>>>> niu
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exam_paper_id = request.getParameter("exam_paper_id");
<<<<<<< HEAD
        System.out.println("get");
        System.out.println(exam_paper_id);
        request.setAttribute("comments_list", selectCommentService.selectComment(exam_paper_id));
        request.getRequestDispatcher("showComments.jsp").forward(request, response);
=======
        request.setAttribute("exam_paper_id", exam_paper_id);
        request.setAttribute("comments_list", selectCommentService.selectComment(exam_paper_id));
        request.getRequestDispatcher("commentpage.jsp").forward(request, response);
>>>>>>> niu
    }


}
