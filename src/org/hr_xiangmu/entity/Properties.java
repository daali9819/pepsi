package org.hr_xiangmu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Properties entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="properties"
    ,catalog="hr_project"
)

public class Properties  implements java.io.Serializable {


    // Fields    

     private Integer propertiesId;
     private String propertiesName;
     private String propertiesDesc;
     private List<Propertiesitems> propertiesitemses = new ArrayList <Propertiesitems>();


    // Constructors

    /** default constructor */
    public Properties() {
    }

	/** minimal constructor */
    public Properties(String propertiesName, String propertiesDesc) {
        this.propertiesName = propertiesName;
        this.propertiesDesc = propertiesDesc;
    }
    
    /** full constructor */
    public Properties(String propertiesName, String propertiesDesc, List<Propertiesitems> propertiesitemses) {
        this.propertiesName = propertiesName;
        this.propertiesDesc = propertiesDesc;
        this.propertiesitemses = propertiesitemses;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="properties_id", unique=true, nullable=false)

    public Integer getPropertiesId() {
        return this.propertiesId;
    }
    
    public void setPropertiesId(Integer propertiesId) {
        this.propertiesId = propertiesId;
    }
    
    @Column(name="properties_name", nullable=false, length=50)

    public String getPropertiesName() {
        return this.propertiesName;
    }
    
    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }
    
    @Column(name="properties_desc", nullable=false, length=50)

    public String getPropertiesDesc() {
        return this.propertiesDesc;
    }
    
    public void setPropertiesDesc(String propertiesDesc) {
        this.propertiesDesc = propertiesDesc;
    }
    @OneToMany(cascade=CascadeType.ALL,mappedBy="properties")
	public List<Propertiesitems> getPropertiesitemses() {
		return propertiesitemses;
	}

	public void setPropertiesitemses(List<Propertiesitems> propertiesitemses) {
		this.propertiesitemses = propertiesitemses;
	}










}