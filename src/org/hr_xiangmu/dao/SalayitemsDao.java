package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Salayitems;

public interface SalayitemsDao {
	public List<Salayitems> getAllSalayitemss();
	
	public void addSalayitems(Salayitems salayitems);
	
	public void updateSalayitems(Salayitems salayitems);
	
	public Salayitems getSalayitemsById(Integer id);
	
	public void deleteSalayitemsById(Integer id);
	
	public List<Salayitems> getSalayitemss(int pageNo, int pageSize, Salayitems condition, String propertyName, String orderBy);
	
	public Integer getCountOfSalayitems(Salayitems condtion);
}











