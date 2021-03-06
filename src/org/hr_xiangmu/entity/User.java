package org.hr_xiangmu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "hr_project")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Role role;
	private String userUsername;
	private String userPassword;
	private String userPhoto;
	private String userMiaoshu;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Role role, String userUsername, String userPassword,
			String userPhoto) {
		this.role = role;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userPhoto = userPhoto;
		
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@ManyToOne()
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	@Column(name = "user_miaoshu", length = 50)
	public String getUserMiaoshu() {
		return userMiaoshu;
	}

	public void setUserMiaoshu(String userMiaoshu) {
		this.userMiaoshu = userMiaoshu;
	}

	@Column(name = "user_username", nullable = false, length = 50)
	public String getUserUsername() {
		return this.userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	@Column(name = "user_password", nullable = false, length = 50)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_photo", nullable = false)
	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	
}