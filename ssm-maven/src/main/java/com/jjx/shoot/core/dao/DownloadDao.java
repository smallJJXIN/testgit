package com.jjx.shoot.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jjx.shoot.core.entity.Download;

@Repository
public interface DownloadDao {
	public List<Download> findDownload(Map<String,String> map);
	
}
