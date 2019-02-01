package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.dao.InsertCommentDao;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.ExamPaperService;
import uk.ac.dundee.group4.service.UserService;
import uk.ac.dundee.group4.util.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * This class contains logical part for allocating users for exam papers.
 */
@WebServlet(name = "AllocatingServlet")
public class AllocatingServlet extends HttpServlet {
    UserService userService = new UserService();
    ExamPaperService examPaperService = new ExamPaperService();

    /**
     * Get list of user id for each role
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] internalModerators = request.getParameterValues(Category.INTERNAL_MODERATOR);
        String[] committeeMembers = request.getParameterValues(Category.EXAM_VETTING_COMMITTEE);
        String[] externalModerators = request.getParameterValues(Category.EXTERNAL_EXAMINER);
        String examPaperId = request.getParameter("examPaperId");
        int examPaper = Integer.parseInt(examPaperId);

        // insert links
        int rst = userService.insertLink(internalModerators, committeeMembers, externalModerators, examPaper);
        if (rst < 0) {
            response.sendRedirect("ListExamPaperServlet");
        } else {
            response.sendRedirect("ShowAllocateServlet");
        }
    }

    /**
     * get links for a exam paper id
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examPaperId = request.getParameter("examPaperId");
        if (examPaperId == null || examPaperId.length() <= 0) {
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        } else {
            int examPaper = Integer.parseInt(examPaperId);
            List<List<User>> users = userService.selectStaff();
            List<HashSet<Integer>> links = examPaperService.selectLinkByExamPaperID(examPaper);
            request.setAttribute("users", users);
            request.setAttribute("examPaperId", examPaperId);
            request.setAttribute("links", links);
            request.getRequestDispatcher("allocating.jsp").forward(request, response);
        }
    }
}
