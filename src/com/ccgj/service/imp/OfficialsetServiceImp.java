package com.ccgj.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccgj.database.beans.Officialset;
import com.ccgj.database.mapper.OfficialsetMapper;
import com.ccgj.service.inter.OfficialsetService;

public class OfficialsetServiceImp implements OfficialsetService {
    @Autowired
    private OfficialsetMapper officialsetMapper;
	
	@Override
	public List<Officialset> searchOfficialsetList() {
		
		return officialsetMapper.selectByExample(null);
	}

	@Override
	public int insertOfficialset(Officialset officialset) {
		officialset.setType(1);
		return officialsetMapper.insert(officialset);
	}

	@Override
	public int updateOfficialsetById(Integer id, Officialset officialset) {
		officialset.setId(id);
		return officialsetMapper.updateByPrimaryKey(officialset);
	}

}
