package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.SelectComment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectCommentDao {

    public List<SelectComment> SelectComment(String exam_paper_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null;
        ResultSet rs = null;
        List<SelectComment> comments = new ArrayList<>();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam4db", "18agileteam4", "7632.at4.2367");
            //String sql = "INSERT INTO comments(comment_id, comment) VALUES ("+comment_id+","+comment+")";
            if (exam_paper_id == "") {
                sql = "Select * from comments";
            } else {
                sql = "Select * from comments where exam_paper_id = " + exam_paper_id;

            }
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SelectComment c = new SelectComment();
                c.setComment_id(rs.getString(1));
                c.setComments(rs.getString(2));
                comments.add(c);
            }

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
        return comments;
    }
}