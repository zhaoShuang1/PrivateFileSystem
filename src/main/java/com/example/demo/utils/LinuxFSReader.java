package com.example.demo.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.FileWrapper;

public class LinuxFSReader implements FSReader{

	@Override
	public List<FileWrapper> getRoots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileWrapper> getSubDir(String dir) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FileWrapper getParent(String sub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void download(String file, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
