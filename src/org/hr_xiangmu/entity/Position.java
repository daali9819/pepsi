package org.hr_xiangmu.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Position entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "position", catalog = "hr_project")
public class Position implements java.io.Serializable {

	// Fields

	private Integer positionId;
	private Orgenization orgenization;
	private String positionName;
	private String positionType;
	private Boolean positionIstrue;
	private Set<Title> titles = new HashSet<Title>(0);

	// Constructors

	/** default constructor */
	public Position() {
	}

	/** minimal constructor */
	public Position(String positionName, String positionType,
			Boolean positionIstrue) {
		this.positionName = positionName;
		this.positionType = positionType;
		this.positionIstrue = positionIstrue;
	}

	/** full constructor */
	public Position(Orgenization orgenization, String positionName,
			String positionType, Boolean positionIstrue, Set<Emp> emps,
			Set<Title> titles) {
		this.orgenization = orgenization;
		this.positionName = positionName;
		this.positionType = positionType;
		this.positionIstrue = positionIstrue;
		this.titles = titles;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "position_id", unique = true, nullable = false)
	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orgenization_id")
	public Orgenization getOrgenization() {
		return this.orgenization;
	}

	public void setOrgenization(Orgenization orgenization) {
		this.orgenization = orgenization;
	}

	@Column(name = "position_name", nullable = false, length = 50)
	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Column(name = "position_type", nullable = false, length = 50)
	public String getPositionType() {
		return this.positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	@Column(name = "position_istrue")
	public Boolean getPositionIstrue() {
		return this.positionIstrue;
	}

	public void setPositionIstrue(Boolean positionIstrue) {
		this.positionIstrue = positionIstrue;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "position")
	public Set<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

}