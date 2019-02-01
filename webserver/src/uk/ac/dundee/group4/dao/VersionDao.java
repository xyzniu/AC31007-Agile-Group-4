package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;

/**
 * This is a Dao for version
 */
public class VersionDao {

    /**
     * insert one version
     *
     * @param version
     * @return
     */
    public int insertOne(Version version) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        int rst = -1;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // insert one version
            String sql = "INSERT INTO version VALUES(default, ?,?,?,?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set values
            ps.setTimestamp(1, version.getTimestamp());
            ps.setString(2, version.getUrl());
            ps.setInt(3, version.getExamPaperId());
            ps.setInt(4, version.getUploaderId());
            ps.executeUpdate();
            resultSet = ps.getGeneratedKeys();
            while (resultSet.next()) {
                // return generated keys
                rst = resultSet.getInt(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
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

        // return -1 if operation failed
        // return version key if operation success
        return rst;
    }

    /**
     * update exampaper id in version table
     *
     * @param versionId
     * @param examPaperId
     * @return
     */
    public int updateExamPaperId(int versionId, int examPaperId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // update the version id
            String sql = "UPDATE version SET exam_paper_ID=? WHERE version_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, examPaperId);
            ps.setInt(2, versionId);
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
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rst;
    }

    /**
     * select url by version id
     * @param versionId
     * @return
     */
    public String selectUrlbyVersionId(int versionId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ResultUrl = null;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // select from version
            String sql = "Select * from version where version_ID=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, versionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                // get version url
                ResultUrl = rs.getString("version_URL");
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
        return ResultUrl;
    }


}
