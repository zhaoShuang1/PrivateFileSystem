package com.example.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.bean.FileWrapper;

public class WindowsFSReader implements FSReader{
	private final String[] ROOTS = new String[] {"c:","d:","e:","f:","g:","h:","i:","j:"}; 
	
	
	@Override
	public List<FileWrapper> getRoots() {
		return Arrays.stream(ROOTS).map((dish)->{
			File file = new File(dish);
			if(file.exists()) {
				return FileWrapper.wrap(file);
			}
			return FileWrapper.NULL;
		}).filter((fw)->fw!=FileWrapper.NULL)
				.collect(Collectors.toList());
	}

	@Override
	public List<FileWrapper> getSubDir(String dir) {
		File file = new File(dir);
		if(file.exists() && 
				file.isDirectory()) {
			File[] subFiles = file.listFiles();
			if(subFiles != null && subFiles.length > 0) {
				return Arrays.stream(subFiles)
						.map(FileWrapper::wrap)
						.collect(Collectors.toList());
			}
		}
		return Collections.emptyList();
	}
	

	@Override
	public FileWrapper getParent(String sub) {
		return FileWrapper.wrap(new File(sub).getParentFile());
	}
	
	
	@Override
	public void download(String file,HttpServletResponse response) {
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			File f = new File(file);
			if(f.exists() && f.isFile()) {
				Files.copy(Paths.get(file), out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FSReader fsReader = FSReaderFactory.newInstance();
		System.out.println(fsReader.getRoots());
		System.out.println(fsReader.getSubDir("d:"));
		System.out.println(fsReader.getParent("d:"));
	}

}
