package org.hr_xiangmu.dao;

import java.util.Date;
import java.util.List;

import org.hr_xiangmu.entity.Emp;
import org.hr_xiangmu.entity.Orgenization;

public interface EmpDao {
	/**
	 * 获得职员入职年度
	 * @return
	 */
	public List<Date> getEmpfilingDates();
	
	public List<Emp> getAllEmps();
	
	public void addEmp(Emp emp);
	
	public void updateEmp(Emp emp);
	
	public Emp getEmpById(Integer id);
	
	public void deleteEmpById(Integer id);
	
	public List<Emp> getEmps(int pageNo, int pageSize, Emp condition, String propertyName, String orderBy);

	public Integer getCountOfEmp(Emp condtion);
	
	public List<Emp> getEmpBycondtion(Emp condtion);
	
	
}











