package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> selectAll(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users  = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("","","");
            String sql = "SELECT * FROM user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPassword(rs.getString(3));
                users.add(u);
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

        return users;

    }

}
