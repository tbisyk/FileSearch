package com.gmail.t.bisyk;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		File myFileSearch = new File("a.txt");
		File folder = new File("D:\\Taras\\Stady\\Less7.3");
		File[] foldList = folder.listFiles();
		int n = 0;
		int k = 0;
		for (File file : foldList) {
			if (file.isDirectory()) {
				n++;
			}
			if (myFileSearch.getName().equals(file.getName())) {
				k++;
				System.out.println(file);
			}
		}
		if (n > 0) {
			ExecutorService es = Executors.newFixedThreadPool(n);
			for (File file : foldList) {
				if (file.isDirectory()) {
					es.submit(new FileSearch(file, myFileSearch));
				}
			}
			es.shutdown();
		}
		FileSearch fs = new FileSearch();
		if ((k+fs.getN())==0) {
			System.out.println(myFileSearch + " no foud");
		}
	}

}
