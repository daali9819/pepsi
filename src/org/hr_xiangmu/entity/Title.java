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
 * Title entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "title", catalog = "hr_project")
public class Title implements java.io.Serializable {

	// Fields

	private Integer titleId;
	private Position position;
	private String titleName;
	private String titleDesc;
	private String titleRemark;
	private Boolean titleIstrue;
	private Orgenization orgenization;
	private Set<Emp> emps = new HashSet<Emp>(0);

	// Constructors

	/** default constructor */
	public Title() {
	}

	/** minimal constructor */
	public Title(Position position, String titleName, String titleDesc,
			String titleRemark, Boolean titleIstrue) {
		this.position = position;
		this.titleName = titleName;
		this.titleDesc = titleDesc;
		this.titleRemark = titleRemark;
		this.titleIstrue = titleIstrue;
	}

	/** full constructor */
	public Title(Position position, String titleName, String titleDesc,
			String titleRemark, Boolean titleIstrue, Set<Emp> emps) {
		this.position = position;
		this.titleName = titleName;
		this.titleDesc = titleDesc;
		this.titleRemark = titleRemark;
		this.titleIstrue = titleIstrue;
		this.emps = emps;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "title_id", unique = true, nullable = false)
	public Integer getTitleId() {
		return this.titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orgenization_id", nullable = false)
	public Orgenization getOrgenization() {
		return orgenization;
	}

	public void setOrgenization(Orgenization orgenization) {
		this.orgenization = orgenization;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = false)
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Column(name = "title_name", nullable = false, length = 50)
	public String getTitleName() {
		return this.titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Column(name = "title_desc", nullable = false, length = 50)
	public String getTitleDesc() {
		return this.titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	@Column(name = "title_remark", nullable = false, length = 50)
	public String getTitleRemark() {
		return this.titleRemark;
	}

	public void setTitleRemark(String titleRemark) {
		this.titleRemark = titleRemark;
	}

	@Column(name = "title_istrue", nullable = false)
	public Boolean getTitleIstrue() {
		return this.titleIstrue;
	}

	public void setTitleIstrue(Boolean titleIstrue) {
		this.titleIstrue = titleIstrue;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "title")
	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}