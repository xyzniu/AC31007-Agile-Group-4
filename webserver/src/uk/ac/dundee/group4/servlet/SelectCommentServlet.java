package uk.ac.dundee.group4.servlet;


import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.LinkService;
import uk.ac.dundee.group4.service.SelectCommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * This is a Servlet dealing with selecting comments.
 */
public class SelectCommentServlet extends HttpServlet {
    SelectCommentService selectCommentService = new SelectCommentService();
    LinkService linkService = new LinkService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Get exam paper id from request.
     * Get all comments by exam paper id.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exam_paper_id = request.getParameter("exam_paper_id");
        request.setAttribute("exam_paper_id", exam_paper_id);
        request.setAttribute("comments_list", selectCommentService.selectComment(exam_paper_id));
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        int examPaperId = Integer.parseInt(exam_paper_id);
        int sign = linkService.selectSign(u, examPaperId);
        request.setAttribute("sign", sign);
        // redirect to show all the comments
        request.getRequestDispatcher("commentpage.jsp").forward(request, response);
    }


}
