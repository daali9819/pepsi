package org.hr_xiangmu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp", catalog = "hr_project")
public class Emp implements java.io.Serializable {

	// Fields

	private Integer empId;
	private Title title;
	private Position position;
	private Orgenization orgenization;
	private Salayitems salayitems;
	private String empName;
	private String empSex;
	private String empEmail;
	private String empAddress;
	private String empPhone;
	private String empIdentity;
	private String empSchool;
	private String empCard;
	private String empState;
	private String empCareer;
	private String empLocalhost;
	private String empStatus;
	private String empBank;
	private String empXueli;
	private String empBankcard;
	private Date empFilingDate;
	private String empPhoto;
	private String empRecord;
	private String empInfo;
	private String empRemark;
	private String empAccessory;
	private String empChange;
	private String empNewstate;
	private String empUpdatedate;
	private String empIsdelete;
	

	private Date starttime;
	private Date endtime;

	// Constructors
	@Transient
	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	@Transient
	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(Title title, Position position, Orgenization orgenization,
			String empName, String empSex,
			String empEmail, String empAddress, String empPhone,
			String empIdentity, String empSchool, String empCard,
			String empState, String empCareer, String empLocalhost,
			String empStatus, String empBank, String empXueli,
			String empBankcard, Date empFilingDate, String empPhoto,
			String empRecord, String empInfo, String empRemark,
			String empAccessory, String empChange, String empNewstate,
			String empUpdatedate, String empIsdelete) {
		this.title = title;
		this.position = position;
		this.orgenization = orgenization;
		this.empName = empName;
		this.empSex = empSex;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
		this.empIdentity = empIdentity;
		this.empSchool = empSchool;
		this.empCard = empCard;
		this.empState = empState;
		this.empCareer = empCareer;
		this.empLocalhost = empLocalhost;
		this.empStatus = empStatus;
		this.empBank = empBank;
		this.empXueli = empXueli;
		this.empBankcard = empBankcard;
		this.empFilingDate = empFilingDate;
		this.empPhoto = empPhoto;
		this.empRecord = empRecord;
		this.empInfo = empInfo;
		this.empRemark = empRemark;
		this.empAccessory = empAccessory;
		this.empChange = empChange;
		this.empNewstate = empNewstate;
		this.empUpdatedate = empUpdatedate;
		this.empIsdelete = empIsdelete;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "emp_id", unique = true, nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "title_id")
	public Title getTitle() {
		return this.title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salayitems_id")
	public Salayitems getSalayitems() {
		return salayitems;
	}

	public void setSalayitems(Salayitems salayitems) {
		this.salayitems = salayitems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orgenization_id")
	public Orgenization getOrgenization() {
		return this.orgenization;
	}

	public void setOrgenization(Orgenization orgenization) {
		this.orgenization = orgenization;
	}


	@Column(name = "emp_name", length = 50)
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name = "emp_sex", length = 50)
	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	@Column(name = "emp_email", length = 50)
	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Column(name = "emp_address", length = 50)
	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Column(name = "emp_phone", length = 50)
	public String getEmpPhone() {
		return this.empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	@Column(name = "emp_identity", length = 50)
	public String getEmpIdentity() {
		return this.empIdentity;
	}

	public void setEmpIdentity(String empIdentity) {
		this.empIdentity = empIdentity;
	}

	@Column(name = "emp_school", length = 50)
	public String getEmpSchool() {
		return this.empSchool;
	}

	public void setEmpSchool(String empSchool) {
		this.empSchool = empSchool;
	}

	@Column(name = "emp_card", length = 50)
	public String getEmpCard() {
		return this.empCard;
	}

	public void setEmpCard(String empCard) {
		this.empCard = empCard;
	}

	@Column(name = "emp_state", length = 50)
	public String getEmpState() {
		return this.empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	@Column(name = "emp_career", length = 50)
	public String getEmpCareer() {
		return this.empCareer;
	}

	public void setEmpCareer(String empCareer) {
		this.empCareer = empCareer;
	}

	@Column(name = "emp_localhost", length = 50)
	public String getEmpLocalhost() {
		return this.empLocalhost;
	}

	public void setEmpLocalhost(String empLocalhost) {
		this.empLocalhost = empLocalhost;
	}

	@Column(name = "emp_status", length = 50)
	public String getEmpStatus() {
		return this.empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	@Column(name = "emp_bank", length = 50)
	public String getEmpBank() {
		return this.empBank;
	}

	public void setEmpBank(String empBank) {
		this.empBank = empBank;
	}

	@Column(name = "emp_xueli", length = 50)
	public String getEmpXueli() {
		return this.empXueli;
	}

	public void setEmpXueli(String empXueli) {
		this.empXueli = empXueli;
	}

	@Column(name = "emp_bankcard", length = 50)
	public String getEmpBankcard() {
		return this.empBankcard;
	}

	public void setEmpBankcard(String empBankcard) {
		this.empBankcard = empBankcard;
	}

	@Column(name = "emp_filingDate", length = 50)
	public Date getEmpFilingDate() {
		return this.empFilingDate;
	}

	public void setEmpFilingDate(Date empFilingDate) {
		this.empFilingDate = empFilingDate;
	}

	@Column(name = "emp_photo", length = 50)
	public String getEmpPhoto() {
		return this.empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	@Column(name = "emp_record", length = 50)
	public String getEmpRecord() {
		return this.empRecord;
	}

	public void setEmpRecord(String empRecord) {
		this.empRecord = empRecord;
	}

	@Column(name = "emp_info", length = 50)
	public String getEmpInfo() {
		return this.empInfo;
	}

	public void setEmpInfo(String empInfo) {
		this.empInfo = empInfo;
	}

	@Column(name = "emp_remark", length = 50)
	public String getEmpRemark() {
		return this.empRemark;
	}

	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}

	@Column(name = "emp_accessory", length = 50)
	public String getEmpAccessory() {
		return this.empAccessory;
	}

	public void setEmpAccessory(String empAccessory) {
		this.empAccessory = empAccessory;
	}

	@Column(name = "emp_change", length = 50)
	public String getEmpChange() {
		return this.empChange;
	}

	public void setEmpChange(String empChange) {
		this.empChange = empChange;
	}

	@Column(name = "emp_newstate", length = 50)
	public String getEmpNewstate() {
		return this.empNewstate;
	}

	public void setEmpNewstate(String empNewstate) {
		this.empNewstate = empNewstate;
	}

	@Column(name = "emp_updatedate", length = 50)
	public String getEmpUpdatedate() {
		return this.empUpdatedate;
	}

	public void setEmpUpdatedate(String empUpdatedate) {
		this.empUpdatedate = empUpdatedate;
	}

	@Column(name = "emp_isdelete", length = 50)
	public String getEmpIsdelete() {
		return this.empIsdelete;
	}

	public void setEmpIsdelete(String empIsdelete) {
		this.empIsdelete = empIsdelete;
	}

	
}