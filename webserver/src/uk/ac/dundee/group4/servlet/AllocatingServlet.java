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

@WebServlet(name = "AllocatingServlet")
public class AllocatingServlet extends HttpServlet {
    UserService userService = new UserService();
    ExamPaperService examPaperService = new ExamPaperService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] internalModerators = request.getParameterValues(Category.INTERNAL_MODERATOR);
        String[] committeeMembers = request.getParameterValues(Category.EXAM_VETTING_COMMITTEE);
        String[] externalModerators = request.getParameterValues(Category.EXTERNAL_EXAMINER);
        String examPaperId = request.getParameter("examPaperId");
        int examPaper = Integer.parseInt(examPaperId);

        int rst = userService.insertLink(internalModerators, committeeMembers, externalModerators, examPaper);
        if (rst < 0) {
            response.sendRedirect("ListExamPaperServlet");
        } else {
            response.sendRedirect("ShowAllocateServlet");
        }
    }

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
