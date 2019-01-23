package uk.ac.dundee.group4.service;

import uk.ac.dundee.group4.dao.VersionDao;
import uk.ac.dundee.group4.pojo.Version;

public class VersionService {

    VersionDao versionDao = new VersionDao();

    public int insertOne(Version version) {
        int rst = versionDao.insertOne(version);

        return rst;
    }

}
