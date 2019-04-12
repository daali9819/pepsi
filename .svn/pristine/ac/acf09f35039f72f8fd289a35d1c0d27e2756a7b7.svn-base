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
 * Rolesysright entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rolesysright", catalog = "hr_project")
public class Rolesysright implements java.io.Serializable {

	// Fields

	private Integer rolerightId;
	private Role role;
	private Sysright sysright;

	// Constructors

	/** default constructor */
	public Rolesysright() {
	}

	/** full constructor */
	public Rolesysright(Role role, Sysright sysright) {
		this.role = role;
		this.sysright = sysright;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "roleright_id", unique = true, nullable = false)
	public Integer getRolerightId() {
		return this.rolerightId;
	}

	public void setRolerightId(Integer rolerightId) {
		this.rolerightId = rolerightId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "sysright_id", nullable = false)
	public Sysright getSysright() {
		return this.sysright;
	}

	public void setSysright(Sysright sysright) {
		this.sysright = sysright;
	}

}