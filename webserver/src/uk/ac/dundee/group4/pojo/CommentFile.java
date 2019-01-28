package uk.ac.dundee.group4.pojo;

import java.sql.Timestamp;

public class CommentFile {
    private int id;
    private int latestVersion;
    private Timestamp timestamp;
    private String url;

    public CommentFile(){

    }
    public CommentFile(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CommentFile{" +
                "id=" + id +
                ", latestVersion=" + latestVersion +
                ", timestamp=" + timestamp +
                ", url='" + url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(int latestVersion) {
        this.latestVersion = latestVersion;
    }
}
