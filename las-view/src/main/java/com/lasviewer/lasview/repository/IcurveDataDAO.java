package com.lasviewer.lasview.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.lasviewer.lasview.models.entity.CurveData;


@Transactional
public interface IcurveDataDAO extends CrudRepository<CurveData, Long> {

    @Modifying 
	@Query(nativeQuery = true,
	  value = "insert into curve_data (value, depth, name) values (:value, :depth, :name)")
	void insertDataCurve(@Param("value") Double value, @Param("depth") Double depth, 
	  @Param("name") String name);
}
