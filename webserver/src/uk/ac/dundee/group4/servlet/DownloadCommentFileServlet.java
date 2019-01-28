package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.service.CommentFileService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DownloadCommentFileServlet extends HttpServlet {
    CommentFileService commentFileService = new CommentFileService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentFileID = request.getParameter("commentFileID");
        if (commentFileID == null || commentFileID.length() <= 0) {
            return;
        } else {
            return;
        }
    }
}

