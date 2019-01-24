package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a Dao for comments
 */
public class CommentDao {

    /**
     * Querying all comments
     * @return
     */
    public List<Comment> selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam4db", "18agileteam4", "7632.at4.2367");
            String sql = "SELECT * FROM comments";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Comment c = new Comment();
                c.setComment_id(rs.getInt(1));
                c.setComments(rs.getString(2));
                comments.add(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
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
        return comments;
    }

}
