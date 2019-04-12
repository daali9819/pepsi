package org.hr_xiangmu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "salayitems", catalog = "hr_project")
public class Salayitems implements Serializable {
	private Integer salayitemsId;
	
	private String salayitemsName;
	
	private String salayitemsMoney;
	
	private String salayitemszhidingren;
	
	private String salayitemsdengluren;
	
	private Date salayitemsdate;
	
	private String salayitemsState;
	
	//private List<SalaySalayitems> salaySalayitems = new ArrayList<SalaySalayitems>();
	
	private Date beginDate;
	
	private Date endDate;
	
	@Transient
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	@Transient
	public Date getEndDate() {
		return endDate;
	}

//	@OneToMany()
//	@JoinColumn(name="salayitems_id")
//	public List<SalaySalayitems> getSalaySalayitems() {
//		return salaySalayitems;
//	}
//
//	public void setSalaySalayitems(List<SalaySalayitems> salaySalayitems) {
//		this.salaySalayitems = salaySalayitems;
//	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "salayitems_id")
	public Integer getSalayitemsId() {
		return salayitemsId;
	}

	public void setSalayitemsId(Integer salayitemsId) {
		this.salayitemsId = salayitemsId;
	}
	
	@Column(name = "salayitems_state", length = 50)
	public String getSalayitemsState() {
		return salayitemsState;
	}

	public void setSalayitemsState(String salayitemsState) {
		this.salayitemsState = salayitemsState;
	}

	@Column(name = "salayitems_name", length = 50)
	public String getSalayitemsName() {
		return salayitemsName;
	}

	public void setSalayitemsName(String salayitemsName) {
		this.salayitemsName = salayitemsName;
	}
	
	@Column(name = "salayitems_money", length = 50)
	public String getSalayitemsMoney() {
		return salayitemsMoney;
	}

	public void setSalayitemsMoney(String salayitemsMoney) {
		this.salayitemsMoney = salayitemsMoney;
	}
	
	@Column(name = "salsyitmes_zhidingren", length = 50)
	public String getSalayitemszhidingren() {
		return salayitemszhidingren;
	}

	public void setSalayitemszhidingren(String salayitemszhidingren) {
		this.salayitemszhidingren = salayitemszhidingren;
	}
	@Column(name = "salayitmes_dengluren", length = 50)
	public String getSalayitemsdengluren() {
		return salayitemsdengluren;
	}

	public void setSalayitemsdengluren(String salayitemsdengluren) {
		this.salayitemsdengluren = salayitemsdengluren;
	}

	@Column(name = "salayitmes_date")
	public Date getSalayitemsdate() {
		return salayitemsdate;
	}

	public void setSalayitemsdate(Date salayitemsdate) {
		this.salayitemsdate = salayitemsdate;
	}
}
