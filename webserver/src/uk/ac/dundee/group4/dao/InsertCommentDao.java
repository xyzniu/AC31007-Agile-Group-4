package uk.ac.dundee.group4.dao;

import java.sql.*;
import java.util.List;

public class InsertCommentDao {

    public InsertCommentDao() {
    }

    public int InsertComment(String comment, String exam_paper_id, String user_id, String staff_type) {

        Connection conn = null;
        PreparedStatement ps = null;
        int rst = -1;


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam4db", "18agileteam4", "7632.at4.2367");
            //String sql = "INSERT INTO comments(comment_id, comment) VALUES ("+comment_id+","+comment+")";
            String sql = "insert INTO comments (comment_id, comment,user_ID,exam_paper_id, staff_type) value ( default ,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, comment);
            ps.setString(2, user_id);
            ps.setString(3, exam_paper_id);
            ps.setString(4, staff_type);
            rst = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

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
        return rst;
    }
}
