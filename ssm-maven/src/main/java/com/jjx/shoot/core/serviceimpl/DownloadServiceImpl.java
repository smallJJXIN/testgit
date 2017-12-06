package com.jjx.shoot.core.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jjx.shoot.core.dao.DownloadDao;
import com.jjx.shoot.core.entity.Download;

@Service("downloadService")
public class DownloadServiceImpl implements com.jjx.shoot.core.service.DownloadService {

	@Resource
	private DownloadDao download;
	
	@Override
	public List<Download> findDownGame(String usertype) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("userType", usertype);
		List<Download> list = download.findDownload(map);
		return list;
	}

}
