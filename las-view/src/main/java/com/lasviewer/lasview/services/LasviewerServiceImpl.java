package com.lasviewer.lasview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lasviewer.lasview.models.entity.CurveData;
import com.lasviewer.lasview.models.entity.CurveInformationParam;
import com.lasviewer.lasview.models.entity.LocationWell;
import com.lasviewer.lasview.models.entity.LogWell;
import com.lasviewer.lasview.models.entity.User;
import com.lasviewer.lasview.models.entity.WellInformation;
import com.lasviewer.lasview.repository.ICurveInformationParasmDAO;
import com.lasviewer.lasview.repository.ILocationWellDAO;
import com.lasviewer.lasview.repository.ILogWellDAO;
import com.lasviewer.lasview.repository.IUserDAO;
import com.lasviewer.lasview.repository.IWellInformationDAO;
import com.lasviewer.lasview.repository.IcurveDataDAO;
import com.lasviewer.lasview.services.interfaces.ILasviewerService;

@Service
public class LasviewerServiceImpl implements ILasviewerService{
	
	@Autowired
	private IcurveDataDAO curveDataDao;
	@Autowired
	private ICurveInformationParasmDAO curveInformationParamDao;
	@Autowired
	private ILocationWellDAO locationWellDao;
	@Autowired
	private ILogWellDAO logWellDao;
	@Autowired
	private IUserDAO userDao;
	@Autowired
	private IWellInformationDAO wellInformationDao;

	@Override
	public void saveCurveData(CurveData curveData) {
		curveDataDao.save(curveData);
		
	}

	@Override
	public void saveCurveInformationParams(CurveInformationParam curveInformationParam) {
		curveInformationParamDao.save(curveInformationParam);
	}

	@Override
	public void saveLocationWell(LocationWell locationWell) {
		locationWellDao.save(locationWell);
		
	}

	@Override
	public void saveLogWell(LogWell logWell) {
		logWellDao.save(logWell);
		
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
		
	}

	@Override
	public void saveWellInforation(WellInformation wellInformation) {
		wellInformationDao.save(wellInformation);
		
	}

}