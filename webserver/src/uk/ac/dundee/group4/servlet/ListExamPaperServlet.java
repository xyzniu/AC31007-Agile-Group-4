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
 * This is a Servlet dealing with listing exam papers.
 */
public class ListExamPaperServlet extends HttpServlet {
    ExamPaperService examPaperService = new ExamPaperService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Get user info by http session.
     * Get exam papers by user info.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        List<ExamPaper> examPapers = null;
        switch (u.getStaffType()) {

            // exam setter can view the exam papers that are set by him
            case Category.EXAM_SETTER:
                examPapers = examPaperService.selectByExamSetter(u.getId(), u.getFirstName() + " " + u.getLastName());
                break;

            // internal moderators can view the exam papers that are allocated to them
            case Category.INTERNAL_MODERATOR:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_INTERNAL_MODERATOR);
                break;

            // exam vetting committees can view the exam papers that are allocated to them
            case Category.EXAM_VETTING_COMMITTEE:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_EXAM_VETTING_COMMITTEE);
                break;

            // external examiners can view the exam papers that are allocated to them
            case Category.EXTERNAL_EXAMINER:
                examPapers = examPaperService.selectByStaffID(u.getId(), Category.LINK_EXTERNAL_EXAMINER);
                break;

            // school office and local exam officers can view all the exam paper.
            case Category.SCHOOL_OFFICE:
            case Category.LOCAL_EXAMS_OFFICER:
                examPapers = examPaperService.selectAll();
                break;

        }

        request.setAttribute("examPapers", examPapers);
        request.getRequestDispatcher("/listAllExamPapers.jsp").forward(request, response);
    }
}
