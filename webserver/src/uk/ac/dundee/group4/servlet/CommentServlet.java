package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.Comment;
import uk.ac.dundee.group4.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "CommentServlet")
public class CommentServlet extends HttpServlet {
    CommentService commentService = new CommentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<Comment> commentList = new ArrayList<>();
        //commentList.add(new Comment(1111, "1111"));
        //commentList.add(new Comment(2222, "2222"));

        request.setAttribute("comments_list", commentService.selectAll());
        System.out.println(commentService.selectAll()
        );

        request.getRequestDispatcher("showComments.jsp").forward(request, response);
    }
}
