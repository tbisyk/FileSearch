package com.gmail.t.bisyk;

import java.io.File;

public class FileSearch implements Runnable {
	private File folder;
	private File fs;
	private volatile int n =0;

	public FileSearch(File file, File myFileSearch) {
		super();
		this.folder = file;
		this.fs = myFileSearch;
	}

	public FileSearch() {
		super();
	}

	public int getN() {
		return n;
	}

	public File getFolder() {
		return folder;
	}

	public void search(File fold) {
		File[] fl = fold.listFiles();
		for (File file : fl) {
			if (file.isDirectory()) search(file);
			if (file.getName().equals(this.fs.getName())) {
				System.out.println(file.getAbsolutePath());
				n = n + 1;
			}
		}
	}

	@Override
	public void run() {
		Thread thr = Thread.currentThread();
		search(this.folder);
	}
}