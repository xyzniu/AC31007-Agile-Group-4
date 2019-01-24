package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.SelectComment;
import uk.ac.dundee.group4.util.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectCommentDao {

    public List<SelectComment> SelectComment(String exam_paper_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<SelectComment> comments = new ArrayList<>();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam4db", "18agileteam4", "7632.at4.2367");
            //String sql = "INSERT INTO comments(comment_id, comment) VALUES ("+comment_id+","+comment+")";
            /*if (exam_paper_id == "") {
                sql = "Select * from comments";
            } else {
                sql = "Select * from comments where exam_paper_id = " + exam_paper_id;

            }
            */

            sql = "Select * from comments where exam_paper_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, exam_paper_id);
            rs = ps.executeQuery();
            sql = "Select * from comments where exam_paper_id = ?";

            while (rs.next()) {
                SelectComment c = new SelectComment();
                c.setComment_id(rs.getString(1));
                c.setComments(rs.getString(2));
                c.setUser_id(rs.getString(3));
                c.setExam_paper_id(rs.getString(4));
                c.setStaff_type(rs.getString(5));

                switch (c.getStaff_type()) {
                    case Category.EXAM_SETTER:
                        sql = "SELECT * FROM exam_setter WHERE exam_setter_ID=?";
                        break;
                    case Category.INTERNAL_MODERATOR:
                        sql = "SELECT * FROM internal_moderator WHERE internal_moderator_ID=?";
                        break;
                    case Category.EXTERNAL_EXAMINER:
                        sql = "SELECT * FROM external_examiner WHERE external_examiner_ID=?";
                        break;
                    case Category.EXAM_VETTING_COMMITTEE:
                        sql = "SELECT * FROM committee_member WHERE commitee_member_ID=?";
                        break;
                }

                ps = conn.prepareStatement(sql);
                ps.setString(1, c.getUser_id());
                rs2 = ps.executeQuery();
                while (rs2.next()) {
                    String firstName = rs2.getString("first_name");
                    String lastName = rs2.getString("last_name");
                    c.setUser_id(firstName + " " + lastName);
                }
                comments.add(c);
                System.out.println(c);
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