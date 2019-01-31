package uk.ac.dundee.group4.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.service.ExamPaperService;
import uk.ac.dundee.group4.service.InsertCommentService;
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


public class InsertCommentFileServlet extends HttpServlet {
    VersionService versionService = new VersionService();
    InsertCommentService insertCommentService = new InsertCommentService();

    /**
     * This is the servlet inserting comment file.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExamPaper examPaper = new ExamPaper();
        String path = "";

        String comment = null;
        String exam_paper_id = null;
        String user_id = null;
        String staff_type = null;
        String version_id = null;

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            if (!ServletFileUpload.isMultipartContent(request)) {
                // should not happen
                return;
            }
            List<FileItem> list = upload.parseRequest(request);

            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    switch (name) {

                        case "comment":
                            comment = value;
                            break;
                        case "exam_paper_id":
                            exam_paper_id = value;
                            break;
                        case "user_id":
                            user_id = value;
                            break;
                        case "staff_type":
                            staff_type = value;
                            break;
                        case "version_id":
                            version_id = value;
                            break;
                        default:
                            System.out.println("No such field.");
                    }
                } else {
                    // if item is a file
                    path = storeItem(item);
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int versionId = -1;
        // if there is a file
        if (path != null && path.length() > 0) {
            // create a new version
            Version v = new Version();
            v.setUrl(path);
            v.setUploaderId(user.getId());
            v.setTimestamp(new Timestamp(System.currentTimeMillis()));
            // changed for code reusable
            v.setStage(Category.TO_SIGN_BY_INTERNAL_MODERATOR);
            v.setExamPaperId(Integer.parseInt(exam_paper_id));
            versionId = versionService.insertOne(v);
        }


        // insert comment
        insertCommentService.insertComment(comment, exam_paper_id, user_id, staff_type, versionId);
        request.getRequestDispatcher("SelectCommentServlet?exam_paper_id=" + exam_paper_id).forward(request, response);

    }

    /**
     * store file items.
     * @param item
     * @return
     * @throws IOException
     */

    private String storeItem(FileItem item) throws IOException {
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
        String path = "_" + System.currentTimeMillis() + fileFormat;
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