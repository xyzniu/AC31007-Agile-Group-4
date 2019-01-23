package uk.ac.dundee.group4.servlet;

import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.service.ExamPaperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "DownloadExamPaperServlet")
public class DownloadExamPaperServlet extends HttpServlet {

    ExamPaperService examPaperService = new ExamPaperService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String moduleCode = request.getParameter("moduleCode");
        String level = request.getParameter("level");
        if (moduleCode == null || moduleCode.length() <= 0 || level == null || level.length() <= 0) {
            return;
        } else {
            Version v = examPaperService.selectUrlByModuleCodeAndLevel(moduleCode, Integer.parseInt(level));
            String url = v.getUrl();
            download(request, response, url);
        }
    }

    private void download(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException {
        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
        String path = fileSaveRootPath + "/" + url;
        File file = new File(path);
        if (!file.exists()) {
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        }
        response.setHeader("content-disposition", "attachment;filename=" + url);
        FileInputStream in = new FileInputStream(path);
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }


}
