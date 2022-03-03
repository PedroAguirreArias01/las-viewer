package com.lasviewer.lasview.repository;

import org.springframework.data.repository.CrudRepository;

import com.lasviewer.lasview.models.entity.WellInformation;

public interface IWellInformationDAO extends CrudRepository<WellInformation, String>{

}
