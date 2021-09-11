package com.lasviewer.lasview.etl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lasviewer.lasview.utils.ConstUtil;

public class ReadFileLas {

	public static final String RESOURCE = "/lasFiles/";
	public static final Logger logger = LoggerFactory.getLogger(ReadFileLas.class);
	
	private boolean isInitSectionInfo;
	private boolean isWellInfo;
	StringBuilder result = new StringBuilder();
	StringBuilder wellInfo = new StringBuilder();
	private boolean isCurverInfo;
	private boolean isParameter;
	private StringBuilder curveInfo = new StringBuilder();
	private boolean isCurveData;
	private StringBuilder curveData = new StringBuilder();
	private boolean isOtherInfo;
	
	public void loadFile() {
		listFilesForFolder().stream()
				.map(pathFile -> ReadFileLas.class.getResourceAsStream(String.format(RESOURCE.concat("%s"), pathFile)))
				.forEachOrdered(inputStream -> {
					this.readFromInputStream(inputStream);
				});
	}

	private void readFromInputStream(final InputStream inputStream) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			Scanner scanner = new Scanner(inputStream);
			String line;
			while (scanner.hasNextLine() && (line = scanner.nextLine()) != null) {
				if (line.startsWith(ConstUtil.INIT_SECTION_INFO)) {
					initInfoWell(line);
					this.isInitSectionInfo = true;
				} else {
					while(this.isInitSectionInfo) {
						if(line.startsWith(ConstUtil.WELL_INFO)) {
							this.isInitSectionInfo = false;
							this.isWellInfo = true;
							break;
						}
						initInfoWell(line);
						line = scanner.nextLine();
					}
					while(this.isWellInfo) {
						if(line.startsWith(ConstUtil.CURVE_INFO)) {
							this.isWellInfo = false;
							this.isCurverInfo = true;
							break;
						}
						getInformationWell(line);
						line = scanner.nextLine();
					}
					while(this.isCurverInfo) {
						if(line.startsWith(ConstUtil.PARAMETER_INFO)) {
							this.isCurverInfo = false;
							this.isParameter = true;
							break;
						}
						getCurveInfo(line);
						line = scanner.nextLine();
					}
					while(this.isParameter) {
						if(line.startsWith(ConstUtil.OTHER_INFO)) {
							this.isParameter = false;
							this.isOtherInfo = true;
							break;
						}
						line = scanner.nextLine();
					}
					while(this.isOtherInfo) {
						if(line.startsWith(ConstUtil.DATA_CURVE)) {
							this.isOtherInfo = false;
							this.isCurveData = true;
							break;
						}
						line = scanner.nextLine();
					}
					while(scanner.hasNextLine() && this.isCurveData) {
						getDataCurve(line);
						line = scanner.nextLine();
					}
				}
			}
			scanner.close();
		} catch (IOException ex) {
			logger.info(ReadFileLas.class.getName());
		}
	}

	public static List<String> listFilesForFolder() {
		logger.warn(ReadFileLas.class.getResource(RESOURCE).getPath());
		File folder = new File(ReadFileLas.class.getResource(RESOURCE).getPath());
		File[] listOfFiles = folder.listFiles();
		List<String> listPathFiles = new ArrayList<>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				listPathFiles.add(file.getName());
			}
		}
		return listPathFiles;
	}

	public static void fileLasDelete() {
		try {
			String path = ReadFileLas.class.getResource(RESOURCE).getPath();
			FileUtils.cleanDirectory(new File(path));
			logger.info("Deleting contents of data dir {}", path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getInformationWell(String info) {
		//logger.info(this.wellInfo.append(info).append("\n").toString());
	}
	
	private void getCurveInfo(String info) {
		//logger.info(this.curveInfo .append(info).append("\n").toString());
		
	}
	
	private void getDataCurve(String info) {
		logger.info(info);
	}
	
	private void initInfoWell(String info) {
		//logger.info(this.result.append(info).append("\n").toString());
	}
}
