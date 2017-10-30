package com.ccgj.service.inter;

import java.util.List;

import com.ccgj.database.beans.Officialset;

public interface OfficialsetService {
    //
	public List<Officialset> searchOfficialsetList();
	
	public int insertOfficialset(Officialset officialset);
	
	public int updateOfficialsetById(Integer id ,Officialset officialset);
	
}
