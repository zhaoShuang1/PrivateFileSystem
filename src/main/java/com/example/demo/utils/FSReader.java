package com.example.demo.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.FileWrapper;


public interface FSReader {

	List<FileWrapper> getRoots();

	List<FileWrapper> getSubDir(String dir);

	FileWrapper getParent(String sub);

	void download(String file, HttpServletResponse response);

}
