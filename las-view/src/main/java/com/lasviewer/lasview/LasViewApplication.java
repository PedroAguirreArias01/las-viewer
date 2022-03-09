package com.lasviewer.lasview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lasviewer.lasview.etl.ReadFileLas;

@SpringBootApplication
public class LasViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(LasViewApplication.class, args);
		ReadFileLas readFileLas = new ReadFileLas();
		readFileLas.loadFile();
		readFileLas.processCurverParams();
	}

}
