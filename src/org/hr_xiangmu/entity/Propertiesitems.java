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
 * Propertiesitems entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="propertiesitems"
    ,catalog="hr_project"
)

public class Propertiesitems  implements java.io.Serializable {


    // Fields    

     private Integer propertiesItemsId;
     private Properties properties;
     private String propertiesItemsName;
     private String propertiesItemsDesc;


    // Constructors

    /** default constructor */
    public Propertiesitems() {
    }

	/** minimal constructor */
    public Propertiesitems(String propertiesItemsName, String propertiesItemsDesc) {
        this.propertiesItemsName = propertiesItemsName;
        this.propertiesItemsDesc = propertiesItemsDesc;
    }
    
    /** full constructor */
    public Propertiesitems(Properties properties, String propertiesItemsName, String propertiesItemsDesc) {
        this.properties = properties;
        this.propertiesItemsName = propertiesItemsName;
        this.propertiesItemsDesc = propertiesItemsDesc;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="propertiesItems_id", unique=true, nullable=false)

    public Integer getPropertiesItemsId() {
        return this.propertiesItemsId;
    }
    
    public void setPropertiesItemsId(Integer propertiesItemsId) {
        this.propertiesItemsId = propertiesItemsId;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="properties_id")

    public Properties getProperties() {
        return this.properties;
    }
    
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
    @Column(name="propertiesItems_name", nullable=false, length=50)

    public String getPropertiesItemsName() {
        return this.propertiesItemsName;
    }
    
    public void setPropertiesItemsName(String propertiesItemsName) {
        this.propertiesItemsName = propertiesItemsName;
    }
    
    @Column(name="propertiesItems_desc", nullable=false, length=50)

    public String getPropertiesItemsDesc() {
        return this.propertiesItemsDesc;
    }
    
    public void setPropertiesItemsDesc(String propertiesItemsDesc) {
        this.propertiesItemsDesc = propertiesItemsDesc;
    }
   








}