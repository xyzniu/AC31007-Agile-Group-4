package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.service.ExamPaperService;
import uk.ac.dundee.group4.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This is a servlet for allocating
 */
@WebServlet(name = "ShowAllocateServlet")
public class ShowAllocateServlet extends HttpServlet {
    ExamPaperService examPaperService = new ExamPaperService();

    // show the exampapers that need to be allocated
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ExamPaper> examPaperList = examPaperService.selectToAllocate();
        request.setAttribute("examPapers", examPaperList);
        request.getRequestDispatcher("allocatingList.jsp").forward(request, response);
    }
}
