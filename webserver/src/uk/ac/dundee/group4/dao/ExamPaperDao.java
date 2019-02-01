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
        // examPaper list
        List<ExamPaper> examPapers = new ArrayList<>();

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // select exam paper by exam setter id
            String sql = "SELECT * FROM exam_paper WHERE exam_setter_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, examSetterId);
            rs = ps.executeQuery();
            while (rs.next()) {
                // wrap object
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
            // close resources
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
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // insert a new exam paper
            String sql = "INSERT INTO exam_paper VALUES (default, ?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // set values
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
        // wrap new version
        Version v = new Version();

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // get the latest version
            String sql = "SELECT * FROM exam_paper e, version v WHERE e.exam_paper_ID=v.exam_paper_ID AND e.exam_paper_ID=? AND v.version_ID=e.latest_version_ID";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, examPaperId);
            rs = ps.executeQuery();
            while (rs.next()) {
                // wrap object
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
            // close resources
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
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // get all exam papers belongs to one exam setter
            String sql = "SELECT * FROM exam_paper ep, exam_setter es WHERE ep.exam_setter_ID=es.exam_setter_ID";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // wrap object
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
            // close resources
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
        // exam papers list
        List<ExamPaper> examPapers = new ArrayList<>();

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // get exam papers belongs to a staff
            String sql = "SELECT * FROM link_table l, exam_paper ep, exam_setter es WHERE l.link_control=? AND l.staff_ID=? AND ep.exam_paper_ID=l.exam_paper_ID AND ep.exam_setter_ID=es.exam_setter_ID";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, type);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                // wrap object
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
            // close resources
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

        // create 4 hash set
        // lists(1): staff type is internal moderator
        // lists(2): staff type is committe member
        // lists(3): staff type is external moderator
        for (int i = 0; i < 4; i++) {
            lists.add(new HashSet<Integer>());
        }

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);

            // get all the staff from link table
            String sql = "SELECT * FROM link_table WHERE exam_paper_ID = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                // add them to hashset by link_control
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
        return lists;
    }

    /**
     * select exampapers that stage = -1 or stage = 0
     *
     * @return
     */
    public List<ExamPaper> selectToAllocate() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ExamPaper> list = new ArrayList<>();

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // select exampapers that stage = -1 or stage = 0
            String sql = "SELECT * FROM exam_paper WHERE stage='-1' OR stage='0'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // wrap object
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
        return list;
    }

    /**
     * change the stage after signing
     *
     * @param type
     * @param examPaperId
     * @return
     */
    public int changeStage(int type, int examPaperId) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rst = -1;

        try {
            // get connection
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBInfo.url, DBInfo.name, DBInfo.password);
            // update to next stage by exam paper id
            String sql = "UPDATE exam_paper SET stage = ? WHERE exam_paper_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, type);
            ps.setInt(2, examPaperId);
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
}
