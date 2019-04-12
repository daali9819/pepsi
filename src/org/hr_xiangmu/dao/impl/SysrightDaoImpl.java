package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.SysrightDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Sysright;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class SysrightDaoImpl extends BaseHibernateDao<Sysright> implements SysrightDao {
	@Override
	public List<Sysright> getAllSysrights(){
		return super.getAll();
	}
	
	@Override
	public void addSysright(Sysright sysright) {
		super.save(sysright);
	}
	
	
	

	@Override
	public void updateSysright(Sysright sysright) {
		super.update(sysright);
	}

	@Override
	public Sysright getSysrightById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteSysrightById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Sysright condition) {
		criteria.add(Restrictions.isNull("parent"));
	}

	@Override
	public List<Sysright> getSysrights(int pageNo, int pageSize, Sysright condition) {
		return super.getPageList(pageNo, pageSize, condition);
	}

	@Override
	public Integer getCountOfSysright(Sysright condition) {
		return super.getCount(condition);
	}

	@Override
	public List<Sysright> sysrights() {
		Session session = super.getSession();
		String hqlString = "from Sysright where parent is null";
		Query query = session.createQuery(hqlString);
		return query.list();
	}

}




