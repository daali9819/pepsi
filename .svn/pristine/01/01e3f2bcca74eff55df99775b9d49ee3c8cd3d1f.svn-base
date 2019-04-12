package org.hr_xiangmu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salay", catalog = "hr_project")
public class Salay implements Serializable {
	
	private Integer salayId;
	
	private String salayName;

	@Id
	@GeneratedValue
	@Column(name = "salay_id")
	public Integer getSalayId() {
		return salayId;
	}

	public void setSalayId(Integer salayId) {
		this.salayId = salayId;
	}
	@Column(name = "salay_name", length = 50)
	public String getSalayName() {
		return salayName;
	}

	public void setSalayName(String salayName) {
		this.salayName = salayName;
	}
	
}
