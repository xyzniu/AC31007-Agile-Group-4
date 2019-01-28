package uk.ac.dundee.group4.service;


import uk.ac.dundee.group4.dao.CommentFileDao;
import uk.ac.dundee.group4.pojo.CommentFile;


import java.util.ArrayList;
import java.util.List;

public class CommentFileService {

    private CommentFileDao dao = new CommentFileDao();

    public List<CommentFile> selectBycommentFileId (int commentFileId) {
        return dao.selectBycommentFileId(commentFileId);
    }
}
