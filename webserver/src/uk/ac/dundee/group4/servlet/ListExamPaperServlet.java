package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.ExamPaperService;
import uk.ac.dundee.group4.util.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * List exam papers.
 */
public class ListExamPaperServlet extends HttpServlet {
    ExamPaperService examPaperService = new ExamPaperService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        List<ExamPaper> examPapers = null;
        switch (u.getStaffType()) {
            case Category.EXAM_SETTER:
                examPapers = examPaperService.selectByExamSetter(u.getId(), u.getFirstName() + " " + u.getLastName());
                break;
            case Category.INTERNAL_MODERATOR:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_INTERNAL_MODERATOR);
                break;
            case Category.EXAM_VETTING_COMMITTEE:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_EXAM_VETTING_COMMITTEE);
                break;
            case Category.EXTERNAL_EXAMINER:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_EXTERNAL_EXAMINER);
                break;
            case Category.SCHOOL_OFFICE:
            case Category.LOCAL_EXAMS_OFFICER:
                examPapers = examPaperService.selectAll();
                break;

        }
        request.setAttribute("examPapers", examPapers);
        request.getRequestDispatcher("/listAllExamPapers.jsp").forward(request, response);
    }
}
