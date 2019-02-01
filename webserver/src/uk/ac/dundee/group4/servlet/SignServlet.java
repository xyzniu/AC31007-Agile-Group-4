package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.dao.LinkDao;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.LinkService;
import uk.ac.dundee.group4.util.Link;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is a servlet for sign function
 */
@WebServlet(name = "SignServlet")
public class SignServlet extends HttpServlet {
    LinkService linkService = new LinkService();

    /**
     * sign a paper, change stage
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");

        String examPaperIdStr = request.getParameter("examPaperId");
        int examPaperId = Integer.parseInt(examPaperIdStr);

        linkService.insertSign(u, examPaperId);

        request.getRequestDispatcher("SelectCommentServlet?exam_paper_id=" + examPaperIdStr).forward(request, response);
    }
}
