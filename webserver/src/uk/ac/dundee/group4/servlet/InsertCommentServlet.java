package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.service.InsertCommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is a Servlet dealing with inserting comments.
 */
public class InsertCommentServlet extends HttpServlet {
    InsertCommentService insertCommentService = new InsertCommentService();

    /**
     * Get comment info from request.
     * Insert comment info.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        String exam_paper_id = request.getParameter("exam_paper_id");
        String user_id = request.getParameter("user_id");
        String staff_type = request.getParameter("staff_type");
        String version_id = request.getParameter("version_id");
        insertCommentService.insertComment(comment, exam_paper_id, user_id, staff_type, version_id);
        request.getRequestDispatcher("SelectCommentServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
