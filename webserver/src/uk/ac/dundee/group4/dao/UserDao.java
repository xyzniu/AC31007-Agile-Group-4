package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.util.Category;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;

public class UserDao {

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
}
