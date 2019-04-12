package org.hr_xiangmu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "train", catalog = "hr_project")
public class Train implements java.io.Serializable {

	// Fields

	private Integer trainId;
	private String trainName;
	private String trainTeacher;
	private Date trainDate;
	private String trainGoal;
	private String trainRenyuan;
	private String trainAbstract;
	private String trainData;
	private String trainOpinion;
	private String trainFeedback;
	private String trainSummary;
	private String trainResult;
	private String trainState;
	//辅助属性》》开始时间		 结束时间
	private Date train_BeginDate;
	private Date train_EndDate;

	@Transient
	public Date getTrain_BeginDate() {
		return train_BeginDate;
	}


	public void setTrain_BeginDate(Date train_BeginDate) {
		this.train_BeginDate = train_BeginDate;
	}

	@Transient
	public Date getTrain_EndDate() {
		return train_EndDate;
	}


	public void setTrain_EndDate(Date train_EndDate) {
		this.train_EndDate = train_EndDate;
	}


	/** default constructor */
	public Train() {
	}

	
	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "train_id", unique = true, nullable = false)
	public Integer getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	@Column(name = "train_name", nullable = true, length = 50)
	public String getTrainName() {
		return this.trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Column(name = "train_teacher", nullable = true, length = 50)
	public String getTrainTeacher() {
		return this.trainTeacher;
	}

	public void setTrainTeacher(String trainTeacher) {
		this.trainTeacher = trainTeacher;
	}

	@Column(name = "train_date", nullable = true, length = 50)
	public Date getTrainDate() {
		return trainDate;
	}


	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	@Column(name = "train_goal", length = 50)
	public String getTrainGoal() {
		return this.trainGoal;
	}

	


	public void setTrainGoal(String trainGoal) {
		this.trainGoal = trainGoal;
	}

	@Column(name = "train_renyuan", nullable = true, length = 50)
	public String getTrainRenyuan() {
		return this.trainRenyuan;
	}

	public void setTrainRenyuan(String trainRenyuan) {
		this.trainRenyuan = trainRenyuan;
	}

	@Column(name = "train_abstract", nullable = true, length = 50)
	public String getTrainAbstract() {
		return this.trainAbstract;
	}

	public void setTrainAbstract(String trainAbstract) {
		this.trainAbstract = trainAbstract;
	}

	@Column(name = "train_data", nullable = true, length = 50)
	public String getTrainData() {
		return this.trainData;
	}

	public void setTrainData(String trainData) {
		this.trainData = trainData;
	}

	@Column(name = "train_opinion", nullable = true, length = 50)
	public String getTrainOpinion() {
		return this.trainOpinion;
	}

	public void setTrainOpinion(String trainOpinion) {
		this.trainOpinion = trainOpinion;
	}

	@Column(name = "train_feedback", nullable = true, length = 50)
	public String getTrainFeedback() {
		return this.trainFeedback;
	}

	public void setTrainFeedback(String trainFeedback) {
		this.trainFeedback = trainFeedback;
	}

	@Column(name = "train_summary", nullable = true, length = 50)
	public String getTrainSummary() {
		return this.trainSummary;
	}

	public void setTrainSummary(String trainSummary) {
		this.trainSummary = trainSummary;
	}

	@Column(name = "train_result", nullable = true, length = 50)
	public String getTrainResult() {
		return this.trainResult;
	}

	public void setTrainResult(String trainResult) {
		this.trainResult = trainResult;
	}

	@Column(name = "train_state", nullable = true, length = 50)
	public String getTrainState() {
		return this.trainState;
	}

	public void setTrainState(String trainState) {
		this.trainState = trainState;
	}

}