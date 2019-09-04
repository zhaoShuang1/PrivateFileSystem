package com.example.demo.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.FileWrapper;

public final class LocalFSUtil {
	private static final FSReader FSREADER = FSReaderFactory.newInstance();
	private LocalFSUtil() {}
	
	public static List<FileWrapper> getRoots(){
		return FSREADER.getRoots();
	}

	public static List<FileWrapper> getSubDir(String dir) {
		return FSREADER.getSubDir(dir);
	}

	public static FileWrapper getParent(String sub) {
		return FSREADER.getParent(sub);
	}

	public static void download(String file, HttpServletResponse response) {
		FSREADER.download(file,response);
	}
	
	
}
