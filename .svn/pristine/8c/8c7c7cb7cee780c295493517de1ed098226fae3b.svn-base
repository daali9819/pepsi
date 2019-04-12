package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.PropertiesitemsDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Propertiesitems;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class PropertiesitemsDaoImpl extends BaseHibernateDao<Propertiesitems> implements PropertiesitemsDao {
	@Override
	public List<Propertiesitems> getAllPropertiesitemss(){
		return super.getAll();
	}
	
	@Override
	public void addPropertiesitems(Propertiesitems propertiesitems) {
		super.save(propertiesitems);
	}

	@Override
	public void updatePropertiesitems(Propertiesitems propertiesitems) {
		super.update(propertiesitems);
	}

	@Override
	public Propertiesitems getPropertiesitemsById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deletePropertiesitemsById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Propertiesitems condition) {
		if(condition != null) {
			Integer id= condition.getProperties().getPropertiesId();
			criteria.add(Restrictions.eq("properties.propertiesId",id));
			
		}
	}

	@Override
	public List<Propertiesitems> getPropertiesitemss(int pageNo, int pageSize, Propertiesitems condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfPropertiesitems(Propertiesitems condition) {
		return super.getCount(condition);
	}

	@Override
	public List<Propertiesitems> getPropertiesitemsByPId(Integer PId) {
		Session session = super.getSession();
		String hql = "from Propertiesitems p where p.properties.propertiesId = :PId";
		Query query = session.createQuery(hql);
		query.setInteger("PId", PId);
		return query.list();
	}

}




