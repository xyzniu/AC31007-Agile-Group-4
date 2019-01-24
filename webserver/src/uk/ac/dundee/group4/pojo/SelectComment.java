package uk.ac.dundee.group4.pojo;

public class SelectComment {

    private String comment_id;
    private String comments;
    private String exam_paper_id;
<<<<<<< HEAD
=======
    private String user_id;
    private String staff_type;
>>>>>>> niu

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
<<<<<<< HEAD
=======
                ", user_id='" + user_id + '\'' +
                ", staff_type='" + staff_type + '\'' +
>>>>>>> niu
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

<<<<<<< HEAD
=======
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStaff_type() {
        return staff_type;
    }

    public void setStaff_type(String staff_type) {
        this.staff_type = staff_type;
    }
>>>>>>> niu
}
