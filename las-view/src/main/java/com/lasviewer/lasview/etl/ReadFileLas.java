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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lasviewer.lasview.models.entity.CurveData;
import com.lasviewer.lasview.models.entity.CurveInformationParam;
import com.lasviewer.lasview.services.interfaces.ILasviewerService;
import com.lasviewer.lasview.utils.ConstUtil;

@Component
public class ReadFileLas {

	public static final String RESOURCE = "/lasFiles/";
	public static final Logger logger = LoggerFactory.getLogger(ReadFileLas.class);

	private boolean isInitSectionInfo;
	private boolean isWellInfo;
	StringBuilder result = new StringBuilder();
	StringBuilder wellInfo = new StringBuilder();
	private boolean isCurverInfo;
	private boolean isParameter;
	private boolean isCurveData;
	private boolean isOtherInfo;

	@Autowired
	private ILasviewerService lasviewerService;

	private List<String> listCurveParams;
	private List<String> listCurveData;
	private List<String> listLocationWell;
	private List<String> listWellInformation;

	public ReadFileLas() {
		this.listCurveParams = new ArrayList<>();
		this.listCurveData = new ArrayList<>();
		this.listLocationWell = new ArrayList<>();
		this.listWellInformation = new ArrayList<>();
	}

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
					while (scanner.hasNextLine()) {
						if (this.isInitSectionInfo) {
							if (line.startsWith(ConstUtil.WELL_INFO)) {
								this.isInitSectionInfo = false;
								this.isWellInfo = true;
								break;
							}
							initInfoWell(line);
						} else if (this.isWellInfo) {
							if (line.startsWith(ConstUtil.CURVE_INFO)) {
								this.isWellInfo = false;
								this.isCurverInfo = true;
								break;
							}
							getInformationWell(line);
						} else if (this.isCurverInfo) {
							if (line.startsWith(ConstUtil.PARAMETER_INFO)) {
								this.isCurverInfo = false;
								this.isParameter = true;
								break;
							}
							getCurveInfo(line);
						} else if (this.isParameter) {
							if (line.startsWith(ConstUtil.OTHER_INFO)) {
								this.isParameter = false;
								this.isOtherInfo = true;
								break;
							}
						} else if (this.isOtherInfo) {
							if (line.startsWith(ConstUtil.DATA_CURVE)) {
								this.isOtherInfo = false;
								this.isCurveData = true;
								break;
							}
						} else if (this.isCurveData) {
							getDataCurve(line);

						}
						line = scanner.nextLine();

					}
					getDataCurve(line);

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
		// logger.info(info);

	}

	private void getCurveInfo(String info) {
		this.listCurveParams.add(info);
	}

	private void getDataCurve(String info) {
		this.listCurveData.add(info.trim().replaceAll("\\s{2,}", ","));
	}

	private void initInfoWell(String info) {
		// logger.info(info);
	}

	public void processCurverParams() {
		listCurveParams.remove(0);
		for (String param : listCurveParams) {
			String[] aux = param.split("[.]", 0);
			String nameParam = aux[0];
			String units = aux[1].split(" ", 0)[0];
			String description = aux[1].split(":")[1];
			if (this.lasviewerService.existsCurveInformationParams(nameParam) != null && !this.lasviewerService.existsCurveInformationParams(nameParam)) {
				CurveInformationParam curveInformationParam = new CurveInformationParam();
				curveInformationParam.setDescription(description);
				curveInformationParam.setName(nameParam);
				curveInformationParam.setUnits(units);
				this.lasviewerService.saveCurveInformationParams(curveInformationParam);
			}
		}
	}

	public void proccessCurveData() {
		String[] headNames= listCurveData.get(4).substring(3).split(",");
		logger.info("headers: "+listCurveData.get(4).substring(3));
		for (int j = 5; j < listCurveData.size(); j++) {
			logger.info("data: "+listCurveData.get(j));
			String[] auxData = listCurveData.get(j).split(",");
			Double depth = Double.parseDouble(auxData[0]);
			for (int k = 1; k < headNames.length; k++) {
				CurveData curveData = new CurveData();
				CurveInformationParam param = this.lasviewerService.getCurveInformationParam(headNames[k]);
				curveData.setDepth(depth);
				curveData.setValue(Double.parseDouble(auxData[k]));
				curveData.setCurveInformationParam(param);
				this.lasviewerService.saveCurveData(curveData);
			}
			
		}
			
	}

	public void clearList() {
		this.listCurveParams = new ArrayList<>();
		this.listCurveData = new ArrayList<>();
		this.listLocationWell = new ArrayList<>();
		this.listWellInformation = new ArrayList<>();
	}
}
