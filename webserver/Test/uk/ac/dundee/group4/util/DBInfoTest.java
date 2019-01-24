package uk.ac.dundee.group4.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * This is a test class for DBInfo
 */
public class DBInfoTest {

    @Test
    public void test() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            Assert.assertNotNull(conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
