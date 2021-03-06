package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hr_xiangmu.dao.OrgenizationDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Orgenization;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class OrgenizationDaoImpl extends BaseHibernateDao<Orgenization> implements OrgenizationDao {
	@Override
	public List<Orgenization> getAllOrgenizations(){
		return super.getAll();
	}
	
	@Override
	public void addOrgenization(Orgenization orgenization) {
		super.save(orgenization);
	}

	@Override
	public void updateOrgenization(Orgenization orgenization) {
		super.update(orgenization);
	}

	@Override
	public Orgenization getOrgenizationById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteOrgenizationById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Orgenization condition) {
		if(condition != null){
			String nameString = condition.getText();
			System.out.println(nameString);
			if(nameString != null){
				criteria.add(Restrictions.ilike("text", nameString, MatchMode.ANYWHERE));
			}
		}
		if(condition == null || condition.getText().equals("")){
			criteria.add(Restrictions.isNull("parent"));
		}
	}

	@Override
	public List<Orgenization> getOrgenizations(int pageNo, int pageSize, Orgenization condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfOrgenization(Orgenization condition) {
		return super.getCount(condition);
	}

	@Override
	public List<Orgenization> orgenizations() {
		Session session = super.getSession();
		String hqlString = "from Orgenization where parent is null or parent.orgenizationId = 1";
		Query query = session.createQuery(hqlString);
		return query.list();
	}

}




