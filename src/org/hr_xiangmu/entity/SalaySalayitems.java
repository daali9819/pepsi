package org.hr_xiangmu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salay_salayitems", catalog = "hr_project")
public class SalaySalayitems implements Serializable {
	private Integer salaysalayitemsId;
	
	private Salay salayId;
	
	private Salayitems salayitemsId;
	
	private String salayMoney;
	
	@Id
	@GeneratedValue
	@Column(name = "salay_salayitems_id")
	public Integer getSalaysalayitemsId() {
		return salaysalayitemsId;
	}

	public void setSalaysalayitemsId(Integer salaysalayitemsId) {
		this.salaysalayitemsId = salaysalayitemsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salay_id")
	public Salay getSalayId() {
		return salayId;
	}

	public void setSalayId(Salay salayId) {
		this.salayId = salayId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salayitems_id")
	public Salayitems getSalayitemsId() {
		return salayitemsId;
	}

	public void setSalayitemsId(Salayitems salayitemsId) {
		this.salayitemsId = salayitemsId;
	}
	
	@Column(name = "salay_money", length = 50)
	public String getSalayMoney() {
		return salayMoney;
	}

	public void setSalayMoney(String salayMoney) {
		this.salayMoney = salayMoney;
	}
}
