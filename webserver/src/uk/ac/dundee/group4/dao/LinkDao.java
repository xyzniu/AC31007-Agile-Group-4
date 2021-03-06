package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.DBInfo;
import uk.ac.dundee.group4.util.Link;

import java.sql.*;

/**
 * This is a dao for link
 */
public class LinkDao {
    /**
     * get connection
     *
     * @return
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * select sign status by user id, user type and exam paper id
     *
     * @param u
     * @param examPaperId
     * @return
     */
    public int selectSign(User u, int examPaperId) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rst = -1;

        try {
            // select sign status by user id, user type and exam paper id
            String sql = "SELECT * FROM link_table WHERE staff_ID=? AND exam_paper_ID=? AND link_control=?";
            ps = connection.prepareStatement(sql);
            // set value
            ps.setInt(1, u.getId());
            ps.setInt(2, examPaperId);
            ps.setInt(3, Link.getLink(u));
            rs = ps.executeQuery();
            while (rs.next()) {
                rst = rs.getInt("sign");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rst;
    }

    /**
     * insert sign by user id, user type and exam paper id
     *
     * @param u
     * @param examPaperId
     * @return
     */
    public int insertSign(User u, int examPaperId) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        int rst = -1;

        try {
            // update sign by user id, user type and exam paper id
            String sql = "UPDATE link_table SET sign = '1' WHERE staff_ID=? AND exam_paper_ID=? AND link_control=?";
            ps = connection.prepareStatement(sql);
            // set value
            ps.setInt(1, u.getId());
            ps.setInt(2, examPaperId);
            ps.setInt(3, Link.getLink(u));
            rst = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close resources
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rst;
    }

    /**
     * check if all the staff have signed
     *
     * @param type
     * @param examPaperId
     * @return
     */
    public boolean selectInOneType(int type, int examPaperId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        // flag: whether all the staff have signed
        boolean flag = true;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM link_table WHERE exam_paper_ID=? AND link_control=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, examPaperId);
            ps.setInt(2, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("sign") == 0) {
                    // if one not signed
                    flag = false;
                    return flag;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
