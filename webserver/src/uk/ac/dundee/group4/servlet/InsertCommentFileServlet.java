package uk.ac.dundee.group4.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InsertCommentFileServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = null;

        try{
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
                        case "moduleCode":
                            System.out.println("moduleCode");
                        default:
                            System.out.println("No such field.");

                    }
                }else {
                    // if item is a file
                    path = storeItem(item);
                    System.out.println(path);
                }

            }

        }catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

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
        String path =  "_" + System.currentTimeMillis() + fileFormat;
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
