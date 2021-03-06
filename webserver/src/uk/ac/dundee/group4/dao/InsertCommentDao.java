package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;
import java.util.List;

/**
 * This is a Dao for inserting comments
 */
public class InsertCommentDao {

    public InsertCommentDao() {
    }

    /**
     * Insert comments by exam paper id, user id and staff type
     *
     * @param comment
     * @param exam_paper_id
     * @param user_id
     * @param staff_type
     * @param version_id
     * @return
     */
    public int InsertComment(String comment, String exam_paper_id, String user_id, String staff_type, int version_id) {

        Connection conn = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // insert new comments
            String sql = "insert INTO comments (comment_id, comment,user_ID,exam_paper_id, staff_type, version_ID) value ( default ,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            // set values
            ps.setString(1, comment);
            ps.setString(2, user_id);
            ps.setString(3, exam_paper_id);
            ps.setString(4, staff_type);
            ps.setInt(5, version_id);
            rst = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close resources
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
        // return -1 if operation failed
        return rst;
    }
}
