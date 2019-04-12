package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Properties;

public interface PropertiesDao {
	public List<Properties> getAllPropertiess();
	
	public void addProperties(Properties properties);
	
	public void updateProperties(Properties properties);
	
	public Properties getPropertiesById(Integer id);
	
	public void deletePropertiesById(Integer id);
	
	public List<Properties> getPropertiess(int pageNo, int pageSize, Properties condition, String propertyName, String orderBy);
	
	public Integer getCountOfProperties(Properties condtion);
}











