package uk.ac.dundee.group4.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Version {

    private int id;
    private Timestamp timestamp;
    private String url;
    private String moduleCode;
    private int uploaderId;

    private int stage;


    public Version() {
    }

    public Version(int id, Timestamp timestamp, String url, String moduleCode, int uploaderId) {
        this.id = id;
        this.timestamp = timestamp;
        this.url = url;
        this.moduleCode = moduleCode;
        this.uploaderId = uploaderId;
    }


    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", url='" + url + '\'' +
                ", moduleCode=" + moduleCode +
                ", uploaderId=" + uploaderId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version = (Version) o;
        return id == version.id &&
                timestamp == version.timestamp &&
                moduleCode == version.moduleCode &&
                uploaderId == version.uploaderId &&
                Objects.equals(url, version.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, url, moduleCode, uploaderId);
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
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
