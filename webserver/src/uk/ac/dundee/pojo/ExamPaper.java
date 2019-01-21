package uk.ac.dundee.group4.pojo;

import java.util.Date;
import java.util.Objects;

public class ExamPaper {

    private int id;
    private String moduleCode;
    private int examSetterId;
    private int format;
    private int type;
    private int level;
    private int latestVersion;
    private Date date;

    public ExamPaper() {
    }

    public ExamPaper(int id, String moduleCode, int examSetterId, int format, int type, int level, int latestVersion, Date date) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.examSetterId = examSetterId;
        this.format = format;
        this.type = type;
        this.level = level;
        this.latestVersion = latestVersion;
        this.date = date;
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
                Objects.equals(date, examPaper.date);
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
                ", date=" + date +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moduleCode, examSetterId, format, type, level, latestVersion, date);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
