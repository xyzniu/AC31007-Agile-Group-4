package uk.ac.dundee.group4.dao;



import uk.ac.dundee.group4.pojo.CommentFile;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentFileDao {

    public List<CommentFile> selectBycommentFileId(int commentFileId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CommentFile> commentFiles = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM exam_paper WHERE commentFileId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, commentFileId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CommentFile commentFile = new CommentFile();
                commentFile.setId(rs.getInt("comment_file_ID"));
                commentFile.setUrl(rs.getString("url"));
                commentFiles.add(commentFile);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return commentFiles;
    }
}
