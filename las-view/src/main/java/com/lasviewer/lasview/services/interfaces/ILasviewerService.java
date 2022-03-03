package com.lasviewer.lasview.services.interfaces;

import com.lasviewer.lasview.models.entity.CurveData;
import com.lasviewer.lasview.models.entity.CurveInformationParam;
import com.lasviewer.lasview.models.entity.LocationWell;
import com.lasviewer.lasview.models.entity.LogWell;
import com.lasviewer.lasview.models.entity.User;
import com.lasviewer.lasview.models.entity.WellInformation;

public interface ILasviewerService {

	public void saveCurveData(CurveData curveData);
	public void saveCurveInformationParams(CurveInformationParam curveInformationParam);
	public void saveLocationWell(LocationWell locationWell);
	public void saveLogWell(LogWell logWell);
	public void saveUser(User user);
	public void saveWellInforation(WellInformation wellInformation);
}
