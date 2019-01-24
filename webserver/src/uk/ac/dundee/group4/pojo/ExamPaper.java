package uk.ac.dundee.group4.pojo;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Exam Paper
 */
public class ExamPaper {

    private int id;
    private String moduleCode;
    private int examSetterId;
    // online or offline
    private int format;
    // main or resit
    private int type;
    // undergraduate or postgraduate
    private int level;
    private int latestVersion;
    private Timestamp timestamp;
    // exam setter name
    private String examSetter;
    private int stage;

    public ExamPaper() {
    }

    public ExamPaper(int id, String moduleCode, int examSetterId, int format, int type, int level, int latestVersion, Timestamp timestamp) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.examSetterId = examSetterId;
        this.format = format;
        this.type = type;
        this.level = level;
        this.latestVersion = latestVersion;
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "ExamPaper{" +
                "id=" + id +
                ", moduleCode='" + moduleCode + '\'' +
                ", examSetterId=" + examSetterId +
                ", format=" + format +
                ", type=" + type +
                ", level=" + level +
                ", latestVersion=" + latestVersion +
                ", timestamp=" + timestamp +
                ", examSetter='" + examSetter + '\'' +
                ", stage=" + stage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamPaper examPaper = (ExamPaper) o;
        return id == examPaper.id &&
                examSetterId == examPaper.examSetterId &&
                format == examPaper.format &&
                type == examPaper.type &&
                level == examPaper.level &&
                latestVersion == examPaper.latestVersion &&
                Objects.equals(moduleCode, examPaper.moduleCode) &&
                Objects.equals(timestamp, examPaper.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleCode, examSetterId, format, type, level, latestVersion, timestamp);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getExamSetterId() {
        return examSetterId;
    }

    public void setExamSetterId(int examSetterId) {
        this.examSetterId = examSetterId;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(int latestVersion) {
        this.latestVersion = latestVersion;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getExamSetter() {
        return examSetter;
    }

    public void setExamSetter(String examSetter) {
        this.examSetter = examSetter;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}

