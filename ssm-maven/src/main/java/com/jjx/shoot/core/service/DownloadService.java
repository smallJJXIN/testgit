package com.jjx.shoot.core.service;

import java.util.List;

import com.jjx.shoot.core.entity.Download;

public interface DownloadService {
	public List<Download> findDownGame(String usertype);
}
