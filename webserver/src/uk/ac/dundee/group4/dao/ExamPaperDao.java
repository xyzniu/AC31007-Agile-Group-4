package uk.ac.dundee.group4.dao;

import uk.ac.dundee.group4.pojo.ExamPaper;
import uk.ac.dundee.group4.pojo.User;
import uk.ac.dundee.group4.pojo.Version;
import uk.ac.dundee.group4.util.Category;
import uk.ac.dundee.group4.util.DBInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * This is a Dao for exam paper
 */
public class ExamPaperDao {

    /**
     * querying exam papers by exam setter id.
     *
     * @param examSetterId
     * @return
     */
    public List<ExamPaper> selectByExamSetter(int examSetterId) {
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
                examPaper.setStage(rs.getInt("stage"));
                examPapers.add(examPaper);
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return examPapers;
    }

    /**
     * insert a exam paper
     *
     * @param examPaper
     * @return
     */
    public int insertOne(ExamPaper examPaper) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rst = -1;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "INSERT INTO exam_paper VALUES (default, ?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, examPaper.getModuleCode());
            ps.setInt(2, examPaper.getExamSetterId());
            ps.setInt(3, examPaper.getFormat());
            ps.setInt(4, examPaper.getType());
            ps.setInt(5, examPaper.getLevel());
            ps.setInt(6, examPaper.getLatestVersion());
            ps.setTimestamp(7, examPaper.getTimestamp());
            ps.setString(8, "");
            ps.setInt(9, 0);
            rst = ps.executeUpdate();
            if (rst > 0) {
                // return exam paper id
                rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    rst = rs.getInt(1);
                }
            }
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
        // return -1 if insert failed
        // return exam paper id if inesrt successfully
        return rst;
    }

    /**
     * querying lastest version by exam paper id
     *
     * @param examPaperId
     * @return
     */
    public Version selectByExamPaperId(int examPaperId) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Version v = new Version();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM exam_paper e, version v WHERE e.exam_paper_ID=v.exam_paper_ID AND e.exam_paper_ID=? AND v.version_ID=e.latest_version_ID";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, examPaperId);
            rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("version_ID"));
                v.setTimestamp(rs.getTimestamp("timestamp"));
                v.setUrl(rs.getString("version_URL"));
                v.setExamPaperId(rs.getInt("exam_paper_ID"));
                v.setUploaderId(rs.getInt("uploader_ID"));
                return v;
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
        return v;
    }

    /**
     * querying all exam papers
     *
     * @return
     */
    public List<ExamPaper> selectAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ExamPaper> examPapers = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM exam_paper ep, exam_setter es WHERE ep.exam_setter_ID=es.exam_setter_ID";
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
                examPaper.setTimestamp(rs.getTimestamp("timestamp"));
                examPaper.setStage(rs.getInt("stage"));
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                examPaper.setExamSetter(firstname + " " + lastname);
                examPapers.add(examPaper);
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
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return examPapers;
    }

    /**
     * querying exam papers by staff id and staff type
     *
     * @param id
     * @param type
     * @return
     */
    public List<ExamPaper> selectByStaffID(int id, int type) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ExamPaper> examPapers = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM link_table l, exam_paper ep, exam_setter es WHERE l.link_control=? AND l.staff_ID=? AND ep.exam_paper_ID=l.exam_paper_ID AND ep.exam_setter_ID=es.exam_setter_ID";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, type);
            ps.setInt(2, id);
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
                examPaper.setStage(rs.getInt("stage"));
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                examPaper.setExamSetter(firstname + " " + lastname);
                examPapers.add(examPaper);
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
        return examPapers;

    }

    /**
     * querying all the links in link table by exam paper ID
     *
     * @param id
     * @return
     */
    public List<HashSet<Integer>> selectLinkByExamPaperID(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<HashSet<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lists.add(new HashSet<Integer>());
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM link_table WHERE exam_paper_ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                switch (rs.getInt("link_control")) {
                    case 1:
                        lists.get(1).add(rs.getInt("staff_ID"));
                        break;
                    case 2:
                        lists.get(2).add(rs.getInt("staff_ID"));
                        break;
                    case 3:
                        lists.get(3).add(rs.getInt("staff_ID"));
                        break;
                }
            }
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

    public List<ExamPaper> selectToAllocate() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ExamPaper> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            String sql = "SELECT * FROM exam_paper WHERE stage='-1' OR stage='0'";
            ps = connection.prepareStatement(sql);
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
                examPaper.setStage(rs.getInt("stage"));
                list.add(examPaper);
            }

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
        return list;
    }
}
