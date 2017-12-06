package com.jjx.shoot.core.controller.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjx.shoot.core.entity.Download;
import com.jjx.shoot.core.service.DownloadService;

@Controller
@RequestMapping("/shoot/download")
public class DownloadGameController {
	
	/**
	 * 根据路径下载游戏的软类
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@RequestMapping("/game.do")
	public void DownloadGameById(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
		String path = request.getServletContext().getRealPath("/")+"shoot\\download\\test.jar";
		File file = new File(path);// path是根据日志路径和文件名拼接出来的
	    String filename = file.getName();// 获取日志文件名称
	    InputStream fis = new BufferedInputStream(new FileInputStream(path));
	    byte[] buffer = new byte[fis.available()];
	    fis.read(buffer);
	    fis.close();
	    response.reset();
	    // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
	    response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
	    response.addHeader("Content-Length", "" + file.length());
	    OutputStream os = new BufferedOutputStream(response.getOutputStream());
	    response.setContentType("application/octet-stream");
	    os.write(buffer);// 输出文件
	    os.flush();
	    os.close();
	}
	
	@Resource
	private DownloadService ds;
	
	@ResponseBody
	@RequestMapping("/getGameList.do")
	public List<Download> getDownload(String usertype){
		List<Download> list = ds.findDownGame(usertype);
		for(Download dl : list) {
			System.out.println(dl.getName());
		}
		return ds.findDownGame(usertype);
	}
}
