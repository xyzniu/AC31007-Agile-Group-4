package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.ExamPaperService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListExamPaperServlet extends HttpServlet {
    ExamPaperService examPaperService = new ExamPaperService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        u.setId(1);
        HttpSession session = request.getSession();
        session.setAttribute("user", u);
        List<ExamPaper> examPapers = examPaperService.selectByExamSetter(u.getId());
        request.setAttribute("examPapers", examPapers);
        request.getRequestDispatcher("/listAllExamSetter.jsp").forward(request, response);
    }
}
