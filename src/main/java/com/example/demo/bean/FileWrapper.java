package com.example.demo.bean;

import java.io.File;

public class FileWrapper {
	public static final FileWrapper NULL = new FileWrapper();
	private String name;
	private String fullPath;
	private long size;
	//0 文件夹  1 文件
	private int type;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public static FileWrapper wrap(File file) {
		if(file == null)
			return NULL;
		FileWrapper wrapper = new FileWrapper();
		wrapper.setName(file.getName());
		wrapper.setFullPath(file.getAbsolutePath());
		wrapper.setSize(file.length());
		wrapper.setType(file.isDirectory()?0:1);
		return wrapper;
	}
	@Override
	public String toString() {
		return "FileWrapper [name=" + name + ", fullPath=" + fullPath + ", size=" + size + ", type=" + type + "]";
	}

}
