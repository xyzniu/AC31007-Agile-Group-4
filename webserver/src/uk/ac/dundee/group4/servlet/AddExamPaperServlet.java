package uk.ac.dundee.group4.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.service.ExamPaperService;
import uk.ac.dundee.group4.service.VersionService;
import uk.ac.dundee.group4.util.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

/**
 * This class contains logical part for add exam papers.
 */
public class AddExamPaperServlet extends HttpServlet {
    VersionService versionService = new VersionService();
    ExamPaperService examPaperService = new ExamPaperService();

    /**
     *
     * Get info of exampaper from request.
     * Store the exampaper in server, and update the data in database.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamPaper examPaper = new ExamPaper();
        String moduleCode = null;
        String path = null;

        try {
            // using apache-commons-fileupload.jar
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            if (!ServletFileUpload.isMultipartContent(request)) {
                // should not happen
                return;
            }
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                // if item is not a file.
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    switch (name) {
                        case "moduleCode":
                            examPaper.setModuleCode(value);
                            moduleCode = value;
                            break;
                        case "format":
                            examPaper.setFormat(Integer.parseInt(value));
                            break;
                        case "type":
                            examPaper.setType(Integer.parseInt(value));
                            break;
                        case "level":
                            examPaper.setLevel(Integer.parseInt(value));
                            break;
                        default:
                            System.out.println("No such field.");
                    }
                } else {
                    // if item is a file
                    path = storeItem(item, moduleCode);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        examPaper.setExamSetterId(user.getId());
        examPaper.setTimestamp(new Timestamp(System.currentTimeMillis()));

        // create a new version
        Version v = new Version();
        v.setUrl(path);
        v.setUploaderId(user.getId());
        v.setTimestamp(new Timestamp(System.currentTimeMillis()));
        // changed for code reusable
        v.setStage(Category.TO_SIGN_BY_INTERNAL_MODERATOR);
        v.setExamPaperId(-1);

        int versionId = versionService.insertOne(v);
        if (versionId > 0) {
            // insert version successfully
            // TODO: 2019-01-24  need to add transactions in database, rollback when something go wrong
            examPaper.setLatestVersion(versionId);
            // insert exampaper
            int examPaperId = examPaperService.insertExamPaper(examPaper);
            // update exampaperid in version table
            versionService.updateExamPaperId(versionId, examPaperId);
            request.setAttribute("msg", "Success!");
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        } else {
            // back with message
            request.setAttribute("msg", "Error when add files!");
            request.getRequestDispatcher("ListExamPaperServlet").forward(request, response);
        }
    }

    /**
     * store files in server
     *
     * @param item  file
     * @param s     module code, also the name of saved file
     * @return
     * @throws IOException
     */
    private String storeItem(FileItem item, String s) throws IOException {
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savePath);
        // create the directory if does not exist
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        String filename = item.getName();
        if (filename == null || filename.trim().equals("")) {
            return null;
        }
        String fileFormat = filename.substring(filename.lastIndexOf("."));
        InputStream in = item.getInputStream();
        String path = s + "_" + System.currentTimeMillis() + fileFormat;
        FileOutputStream out = new FileOutputStream(savePath + "/" + path);
        // save
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
        item.delete();
        return path;
    }
}
