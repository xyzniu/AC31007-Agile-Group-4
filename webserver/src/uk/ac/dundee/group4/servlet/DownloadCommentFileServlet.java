package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.service.VersionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This is a servlet for showing comments and downloading files
 */
public class DownloadCommentFileServlet extends HttpServlet {
    VersionService versionService = new VersionService();


    /**
     * download files
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commentId = request.getParameter("versionId");
        String exampaperId = request.getParameter("exampaperId");
        if (commentId == null || commentId.length() <= 0) {
            return;
        } else {
            String url = versionService.selectUrlbyVersionId(Integer.parseInt(commentId));
            download(request, response, url, exampaperId);
        }
    }

    /**
     * real download part
     * @param request
     * @param response
     * @param url
     * @param exampaperId
     * @throws IOException
     * @throws ServletException
     */
    private void download(HttpServletRequest request, HttpServletResponse response, String url, String exampaperId) throws IOException, ServletException {
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        String path = fileSaveRootPath + "/" + url;
        File file = new File(path);
        if (!file.exists()) {
            // redirect to ListExamPaperServlet if the file does not exist.
            request.getRequestDispatcher("SelectCommentServlet?exam_paper_id=" + exampaperId).forward(request, response);
        }
        response.setHeader("content-disposition", "attachment;filename=" + url);
        FileInputStream in = new FileInputStream(path);
        OutputStream out = response.getOutputStream();
        // download
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}

