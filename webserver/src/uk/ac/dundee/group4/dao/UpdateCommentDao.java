package uk.ac.dundee.group4.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This is a Dao for update comments
 */
public class UpdateCommentDao {

    /**
     * update comments by comment id and new comment
     *
     * @param comment_id
     * @param comment
     */
    public void UpdateComment(String comment_id, String comment) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/18agileteam4db", "18agileteam4", "7632.at4.2367");
            //String sql = "INSERT INTO comments(comment_id, comment) VALUES ("+comment_id+","+comment+")";
            String sql = "update comments SET comment =" + comment + " WHERE comment_id =  " + comment_id;
            ps = conn.prepareStatement(sql);
            ps.execute();
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

    }

}
