package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.LocalFSUtil;

@RestController
public class PrivateFileSystemController {
	
	@GetMapping("/getRoots")
	@ResponseBody
	public Object getRoots() {
		return LocalFSUtil.getRoots();
	}
	
	@GetMapping("/getSubDir")
	@ResponseBody
	public Object getSubDir(@RequestParam("dir")String dir) {
		return LocalFSUtil.getSubDir(dir);
	}
	
	@GetMapping("/getParent")
	@ResponseBody
	public Object getParent(@RequestParam("sub")String sub) {
		return LocalFSUtil.getParent(sub);
	}
	
	@GetMapping("/download")
	@ResponseBody
	public void download(@RequestParam("file")String file,
			HttpServletResponse response) {
		LocalFSUtil.download(file,response);
	}
	
}
