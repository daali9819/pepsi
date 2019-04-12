package org.hr_xiangmu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.SalayitemsDao;
import org.hr_xiangmu.entity.Salayitems;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class SalayitemsDaoImpl extends BaseHibernateDao<Salayitems> implements SalayitemsDao {
	@Override
	public List<Salayitems> getAllSalayitemss(){
		return super.getAll();
	}
	
	@Override
	public void addSalayitems(Salayitems salayitems) {
		super.save(salayitems);
	}

	@Override
	public void updateSalayitems(Salayitems salayitems) {
		super.update(salayitems);
	}

	@Override
	public Salayitems getSalayitemsById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteSalayitemsById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Salayitems condition) {
		if(condition != null) {
			
			String nameString = condition.getSalayitemsName();
			System.out.println(nameString);
			if(nameString != null && !nameString.equals("")){
				criteria.add(Restrictions.ilike("salayitemsName", nameString, MatchMode.ANYWHERE));
			}
			String State = condition.getSalayitemsState();
			System.out.println(State);
			if(State != null && !State.equals("")){
				criteria.add(Restrictions.eq("salayitemsState", State));
			}
			Date beginDate = condition.getBeginDate();
			Date endDate = condition.getEndDate();
		
			if(beginDate != null && endDate == null){
				criteria.add(Restrictions.gt("salayitemsdate", beginDate));
			}
			
			if(beginDate == null && endDate != null){
				criteria.add(Restrictions.lt("salayitemsdate", endDate));
			}
			if(beginDate != null && endDate != null){
				criteria.add(Restrictions.between("salayitemsdate", beginDate, endDate));
			}
			
		}
	}

	@Override
	public List<Salayitems> getSalayitemss(int pageNo, int pageSize, Salayitems condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfSalayitems(Salayitems condition) {
		return super.getCount(condition);
	}

}




