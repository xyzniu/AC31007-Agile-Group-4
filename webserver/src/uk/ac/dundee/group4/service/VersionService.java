package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.VersionDao;
import uk.ac.dundee.group4.pojo.Version;

/**
 * This is a Service dealing with versions.
 */
public class VersionService {

    VersionDao versionDao = new VersionDao();

    /**
     * insert one version
     *
     * @param version
     * @return
     */
    public int insertOne(Version version) {
        int rst = versionDao.insertOne(version);

        return rst;
    }

    /**
     * update exampaper by version id and exam paper id
     *
     * @param versionId
     * @param examPaperId
     * @return
     */
    public int updateExamPaperId(int versionId, int examPaperId) {
        return versionDao.updateExamPaperId(versionId, examPaperId);
    }

    /**
     * select url by version id
     *
     * @param versionId
     * @return
     */
    public String selectUrlbyVersionId(int versionId) {
        return versionDao.selectUrlbyVersionId(versionId);
    }

}
