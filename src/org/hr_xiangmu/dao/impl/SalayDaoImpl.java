package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.SalayDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Salay;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class SalayDaoImpl extends BaseHibernateDao<Salay> implements SalayDao {
	@Override
	public List<Salay> getAllSalays(){
		return super.getAll();
	}
	
	@Override
	public void addSalay(Salay salay) {
		super.save(salay);
	}

	@Override
	public void updateSalay(Salay salay) {
		super.update(salay);
	}

	@Override
	public Salay getSalayById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteSalayById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Salay condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Salay> getSalays(int pageNo, int pageSize, Salay condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfSalay(Salay condition) {
		return super.getCount(condition);
	}

}




