package uk.ac.dundee.group4.pojo;

public class SelectComment {

    private String comment_id;
    private String comments;
    private String exam_paper_id;

    public SelectComment() {
    }

    public SelectComment(String id, String comments) {
        this.comment_id = id;
        this.comments = comments;
        this.exam_paper_id = exam_paper_id;
    }

    @Override
    public String toString() {
        return "SelectComment{" +
                "comment_id='" + comment_id + '\'' +
                ", comments='" + comments + '\'' +
                ", exam_paper_id='" + exam_paper_id + '\'' +
                '}';
    }

    public String getExam_paper_id() {
        return exam_paper_id;
    }

    public void setExam_paper_id(String exam_paper_id) {
        this.exam_paper_id = exam_paper_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }
    public String getCommentsbyId(int comment_id) {

        return comments;
    }

}
