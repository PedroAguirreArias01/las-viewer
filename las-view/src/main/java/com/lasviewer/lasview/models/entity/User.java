package com.lasviewer.lasview.models.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "name_user", nullable = false, unique = true)
	private String nameUser;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "state_user")
	private Character stateUser;
	
	@Column(name = "create_at")
	
	private LocalDate createAt;
		
	
	public User() {
		super();
	}
	
	@PrePersist
	public void prepersistCreate () {
		this.createAt = LocalDate.now();
		this.stateUser = 1;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nameUser
	 */
	public String getNameUser() {
		return nameUser;
	}

	/**
	 * @param nameUser the nameUser to set
	 */
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the stateUser
	 */
	public Character getStateUser() {
		return stateUser;
	}

	/**
	 * @param stateUser the stateUser to set
	 */
	public void setStateUser(Character stateUser) {
		this.stateUser = stateUser;
	}

	/**
	 * @return the createAt
	 */
	public LocalDate getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt the createAt to set
	 */
	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}


	
	

}
