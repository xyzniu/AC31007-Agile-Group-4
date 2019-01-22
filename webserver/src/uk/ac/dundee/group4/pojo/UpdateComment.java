package uk.ac.dundee.group4.pojo;

public class UpdateComment {



        private int comment_id;
        private String comments;

        public UpdateComment() {
        }

        public UpdateComment(int id, String comments) {
            this.comment_id = id;
            this.comments = comments;
        }

        @Override
        public String toString() {
            return "Comment{" +
                    "comment_id=" + comment_id +
                    ", comments='" + comments + '\'' +
                    '}';
        }

        public void setComment_id(int comment_id) {
            this.comment_id = comment_id;
        }

        public int getComment_id() {
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
