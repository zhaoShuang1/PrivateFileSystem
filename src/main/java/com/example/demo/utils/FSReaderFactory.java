package com.example.demo.utils;


public final class FSReaderFactory {
	private FSReaderFactory() {}
	
	public static FSReader newInstance() {
		if(OSUtil.isWindows())
			return new WindowsFSReader();
		if(OSUtil.isLinux())
			return new LinuxFSReader();
		
		return null;
	}
}
