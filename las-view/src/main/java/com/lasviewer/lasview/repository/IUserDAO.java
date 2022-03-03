package com.lasviewer.lasview.repository;

import org.springframework.data.repository.CrudRepository;

import com.lasviewer.lasview.models.entity.User;

public interface IUserDAO extends CrudRepository<User, Long>{

}
