package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.InsertCommentDao;
<<<<<<< HEAD
import uk.ac.dundee.group4.pojo.InsertComment;

import java.util.List;

;
=======

>>>>>>> niu

public class InsertCommentService {

    private InsertCommentDao insertCommentDao = new InsertCommentDao();

<<<<<<< HEAD
    public void insertComment(String comment_id, String comment){
        System.out.println(comment_id);
        System.out.println(comment);
        insertCommentDao.InsertComment(comment_id,comment);
=======

    public void insertComment(String comment, String exam_paper_id, String user_id, String staff_type) {
        insertCommentDao.InsertComment(comment, exam_paper_id, user_id, staff_type);
>>>>>>> niu
    }
}
