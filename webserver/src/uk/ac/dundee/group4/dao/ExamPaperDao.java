package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamPaperDao {

    public List<ExamPaper> selectAll(int examSetterId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ExamPaper> examPapers = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM exam_paper WHERE exam_setter_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, examSetterId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ExamPaper examPaper = new ExamPaper();
                examPaper.setId(rs.getInt("exam_paper_ID"));
                examPaper.setModuleCode(rs.getString("module_code"));
                examPaper.setExamSetterId(rs.getInt("exam_setter_ID"));
                examPaper.setFormat(rs.getInt("format"));
                examPaper.setType(rs.getInt("type"));
                examPaper.setLevel(rs.getInt("level"));
                examPaper.setLatestVersion(rs.getInt("latest_version_ID"));
                examPaper.setTimestamp(rs.getTimestamp("timestamp"));
                examPapers.add(examPaper);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examPapers;
    }

    public int insertOne(ExamPaper examPaper) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "INSERT INTO exam_paper VALUES (default, ?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, examPaper.getModuleCode());
            ps.setInt(2, examPaper.getExamSetterId());
            ps.setInt(3, examPaper.getFormat());
            ps.setInt(4, examPaper.getType());
            ps.setInt(5, examPaper.getLevel());
            ps.setInt(6, examPaper.getLatestVersion());
            ps.setTimestamp(7, examPaper.getTimestamp());
            ps.setString(8, "");
            rst = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

}
