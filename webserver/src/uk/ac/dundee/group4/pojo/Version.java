package uk.ac.dundee.group4.pojo;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Encapsulation for Version
 */
public class Version {

    private int id;
    private Timestamp timestamp;
    private String url;
    private int examPaperId;
    private int uploaderId;

    private int stage;


    public Version() {
    }

    public Version(int id, Timestamp timestamp, String url, int examPaperId, int uploaderId, int stage) {
        this.id = id;
        this.timestamp = timestamp;
        this.url = url;
        this.examPaperId = examPaperId;
        this.uploaderId = uploaderId;
        this.stage = stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return id == version.id &&
                examPaperId == version.examPaperId &&
                uploaderId == version.uploaderId &&
                stage == version.stage &&
                Objects.equals(timestamp, version.timestamp) &&
                Objects.equals(url, version.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, url, examPaperId, uploaderId, stage);
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", url='" + url + '\'' +
                ", examPaperId=" + examPaperId +
                ", uploaderId=" + uploaderId +
                ", stage=" + stage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId) {
        this.examPaperId = examPaperId;
    }

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
}
