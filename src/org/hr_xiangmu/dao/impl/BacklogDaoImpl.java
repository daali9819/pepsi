package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.BacklogDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Backlog;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class BacklogDaoImpl extends BaseHibernateDao<Backlog> implements BacklogDao {
	@Override
	public List<Backlog> getAllBacklogs(){
		return super.getAll();
	}
	
	@Override
	public void addBacklog(Backlog backlog) {
		super.save(backlog);
	}

	@Override
	public void updateBacklog(Backlog backlog) {
		super.update(backlog);
	}

	@Override
	public Backlog getBacklogById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteBacklogById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Backlog condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Backlog> getBacklogs(int pageNo, int pageSize, Backlog condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfBacklog(Backlog condition) {
		return super.getCount(condition);
	}

}




