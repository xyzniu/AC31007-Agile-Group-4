package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.Category;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is a Dao for user
 */
public class UserDao {

    /**
     * querying user by username password and staff type
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    public User selectByUsernamePasswordAndType(String username, String password, String type) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = null;
            if (type.equals(Category.EXAM_SETTER)) {
                sql = "SELECT * FROM exam_setter WHERE username=? AND password=?";
            } else if (type.equals(Category.INTERNAL_MODERATOR)) {
                sql = "SELECT * FROM internal_moderator WHERE username=? AND password=?";
            } else if (type.equals(Category.EXTERNAL_EXAMINER)) {
                sql = "SELECT * FROM external_examiner WHERE username=? AND password=?";
            } else if (type.equals(Category.SCHOOL_OFFICE)) {
                sql = "SELECT * FROM school_office_staff WHERE username=? AND password=?";
            } else if (type.equals(Category.EXAM_VETTING_COMMITTEE)) {
                sql = "SELECT * FROM committee_member WHERE username=? AND password=?";
            } else {
                sql = "SELECT * FROM local_exams_officer WHERE username=? AND password=?";
            }
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(username);
                u.setPassword(password);
                u.setPhone(rs.getString("phone_number"));
                u.setEmail(rs.getString("email_address"));
                u.setStaffType(type);
                return u;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * querying all staff including internal moderator, committee member and external examiner.
     *
     * @return
     */
    public List<List<User>> selectStaff() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<List<User>> lists = new LinkedList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String[] sql = new String[3];
            String sql1 = "SELECT * FROM internal_moderator";
            String sql2 = "SELECT * FROM committee_member";
            String sql3 = "SELECT * FROM external_examiner";
            ps = connection.prepareStatement(sql1);
            rs = ps.executeQuery();
            List<User> list1 = new ArrayList<>();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("internal_moderator_ID"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email_address"));
                u.setPhone(rs.getString("phone_number"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStaffType(Category.INTERNAL_MODERATOR);
                list1.add(u);
            }
            lists.add(list1);

            ps = connection.prepareStatement(sql2);
            rs = ps.executeQuery();
            List<User> list2 = new ArrayList<>();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("commitee_member_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email_address"));
                u.setPhone(rs.getString("phone_number"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStaffType(Category.EXAM_VETTING_COMMITTEE);
                list2.add(u);
            }
            lists.add(list2);

            ps = connection.prepareStatement(sql3);
            rs = ps.executeQuery();
            List<User> list3 = new ArrayList<>();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("external_examiner_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email_address"));
                u.setPhone(rs.getString("phone_number"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setStaffType(Category.EXTERNAL_EXAMINER);
                list3.add(u);
            }
            lists.add(list3);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return lists;
    }

    /**
     * @param internalModerators
     * @param committeeMembers
     * @param externalModerators
     * @param examPaperId
     * @return
     */
    public int insertLink(List<Integer> internalModerators, List<Integer> committeeMembers, List<Integer> externalModerators, int examPaperId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql0 = "DELETE FROM link_table WHERE exam_paper_ID=?";
            ps = connection.prepareStatement(sql0);
            ps.setInt(1, examPaperId);
            ps.executeUpdate();

            String sql = "INSERT INTO link_table VALUES(default,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < internalModerators.size(); i++) {
                ps.setInt(1, examPaperId);
                ps.setInt(2, internalModerators.get(i));
                ps.setInt(3, Category.LINK_INTERNAL_MODERATOR);
                ps.setInt(4, Category.NOTSIGN);
                rst += ps.executeUpdate();
            }
            for (int i = 0; i < committeeMembers.size(); i++) {
                ps.setInt(1, examPaperId);
                ps.setInt(2, committeeMembers.get(i));
                ps.setInt(3, Category.LINK_EXAM_VETTING_COMMITTEE);
                ps.setInt(4, Category.NOTSIGN);
                rst += ps.executeUpdate();
            }
            for (int i = 0; i < externalModerators.size(); i++) {
                ps.setInt(1, examPaperId);
                ps.setInt(2, externalModerators.get(i));
                ps.setInt(3, Category.LINK_EXTERNAL_EXAMINER);
                ps.setInt(4, Category.NOTSIGN);
                rst += ps.executeUpdate();
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rst;
    }
}
