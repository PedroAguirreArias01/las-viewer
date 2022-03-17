package com.lasviewer.lasview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lasviewer.lasview.etl.ReadFileLas;

@RestController
@CrossOrigin("*")
public class lasViewController {
	
	@Autowired
	private ReadFileLas readFileLas;

	@GetMapping("/startApi")
	public ResponseEntity<?> startAplication(){
		readFileLas.loadFile();
		readFileLas.processCurverParams();
		readFileLas.proccessCurveData();
		return new ResponseEntity("Hola Mundo!", HttpStatus.OK);
	}
}
