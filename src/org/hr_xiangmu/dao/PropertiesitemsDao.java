package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Propertiesitems;

public interface PropertiesitemsDao {
	public List<Propertiesitems> getAllPropertiesitemss();
	
	public List<Propertiesitems> getPropertiesitemsByPId(Integer PId);
	
	public void addPropertiesitems(Propertiesitems propertiesitems);
	
	public void updatePropertiesitems(Propertiesitems propertiesitems);
	
	public Propertiesitems getPropertiesitemsById(Integer id);
	
	public void deletePropertiesitemsById(Integer id);
	
	public List<Propertiesitems> getPropertiesitemss(int pageNo, int pageSize, Propertiesitems condition, String propertyName, String orderBy);
	
	public Integer getCountOfPropertiesitems(Propertiesitems condtion);
}











