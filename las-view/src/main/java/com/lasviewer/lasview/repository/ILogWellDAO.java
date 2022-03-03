package com.lasviewer.lasview.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.lasviewer.lasview.models.entity.LogWell;

public interface ILogWellDAO extends CrudRepository<LogWell, Date>{

}
