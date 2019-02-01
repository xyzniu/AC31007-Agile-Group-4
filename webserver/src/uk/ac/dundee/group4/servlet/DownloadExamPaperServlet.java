package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.service.ExamPaperService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * This is a Servlet dealing with downloading exampapers
 */
public class DownloadExamPaperServlet extends HttpServlet {

    ExamPaperService examPaperService = new ExamPaperService();


    /**
     * Get exampaper id from request.
     * Get url by querying database.
     * Download file.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String versionId = request.getParameter("examPaperId");
        if (versionId == null || versionId.length() <= 0) {
            return;
        } else {
            Version v = examPaperService.selectUrlExamPaperId(Integer.parseInt(versionId));
            String url = v.getUrl();
            download(request, response, url);
        }
    }

    /**
     * Download the file by url
     *
     * @param request
     * @param response
     * @param url
     * @throws IOException
     * @throws ServletException
     */
    private void download(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        String path = fileSaveRootPath + "/" + url;
        File file = new File(path);
        if (!file.exists()) {
            // redirect to ListExamPaperServlet if the file does not exist.
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
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
