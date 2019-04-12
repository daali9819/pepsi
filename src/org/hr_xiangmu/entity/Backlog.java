package org.hr_xiangmu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Backlog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "backlog", catalog = "hr_project")
public class Backlog implements java.io.Serializable {

	// Fields

	private Integer backlogId;
	private String backlogType;
	private String backlogName;
	private String backlogDate;
	private Integer id;
	private String backlogShenheren;

	// Constructors

	/** default constructor */
	public Backlog() {
	}

	/** full constructor */
	public Backlog(String backlogType, String backlogName, String backlogDate,
			Integer id) {
		this.backlogType = backlogType;
		this.backlogName = backlogName;
		this.backlogDate = backlogDate;
		this.id = id;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "backlog_id", unique = true, nullable = false)
	public Integer getBacklogId() {
		return this.backlogId;
	}

	public void setBacklogId(Integer backlogId) {
		this.backlogId = backlogId;
	}

	@Column(name = "backlog_type", nullable = false, length = 50)
	public String getBacklogType() {
		return this.backlogType;
	}
	@Column(name = "backlog_shenheren", nullable = false, length = 50)
	public String getBacklogShenheren() {
		return backlogShenheren;
	}

	public void setBacklogShenheren(String backlogShenheren) {
		this.backlogShenheren = backlogShenheren;
	}

	public void setBacklogType(String backlogType) {
		this.backlogType = backlogType;
	}

	@Column(name = "backlog_name", nullable = false, length = 50)
	public String getBacklogName() {
		return this.backlogName;
	}

	public void setBacklogName(String backlogName) {
		this.backlogName = backlogName;
	}

	@Column(name = "backlog_date", nullable = false, length = 50)
	public String getBacklogDate() {
		return this.backlogDate;
	}

	public void setBacklogDate(String backlogDate) {
		this.backlogDate = backlogDate;
	}

	@Column(name = "bid", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}