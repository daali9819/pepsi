package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Salay;

public interface SalayDao {
	public List<Salay> getAllSalays();
	
	public void addSalay(Salay salay);
	
	public void updateSalay(Salay salay);
	
	public Salay getSalayById(Integer id);
	
	public void deleteSalayById(Integer id);
	
	public List<Salay> getSalays(int pageNo, int pageSize, Salay condition, String propertyName, String orderBy);
	
	public Integer getCountOfSalay(Salay condtion);
}











