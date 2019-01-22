package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;

public class VersionDao {

    public int insertOne(Version version) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "INSERT INTO version VALUES(default, ?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setTimestamp(1, version.getTimestamp());
            ps.setString(2, version.getUrl());
            ps.setString(3, version.getModuleCode());
            ps.setInt(4, version.getUploaderId());
            ps.setInt(5, version.getStage());
            rst = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rst;
    }

}
