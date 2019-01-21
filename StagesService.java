package uk.dundee.ac.group.service;

import java.util.List;


import uk.dundee.ac.group4.dao.LatestVersion;

public class StagesService {
	private StagesDao stagesDao = new StagesDao();
	public List<LatestVersion> selectAll(){
        return stagesDao.selectAll();

}}
