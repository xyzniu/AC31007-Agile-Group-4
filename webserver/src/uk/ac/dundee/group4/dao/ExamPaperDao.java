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
            String sql = "SELECT * FROM exam_paper";
            ps = conn.prepareStatement(sql);
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
                examPaper.setDate(rs.getDate("date"));
                examPapers.add(examPaper);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return examPapers;
    }

}
