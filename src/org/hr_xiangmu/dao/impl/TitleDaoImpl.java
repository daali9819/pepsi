package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.TitleDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Title;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class TitleDaoImpl extends BaseHibernateDao<Title> implements TitleDao {
	@Override
	public List<Title> getAllTitles(){
		return super.getAll();
	}
	
	@Override
	public void addTitle(Title title) {
		super.save(title);
	}

	@Override
	public void updateTitle(Title title) {
		super.update(title);
	}

	@Override
	public Title getTitleById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteTitleById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Title condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Title> getTitles(int pageNo, int pageSize, Title condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfTitle(Title condition) {
		return super.getCount(condition);
	}

}




