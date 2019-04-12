package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.PropertiesDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Properties;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class PropertiesDaoImpl extends BaseHibernateDao<Properties> implements PropertiesDao {
	@Override
	public List<Properties> getAllPropertiess(){
		return super.getAll();
	}
	
	@Override
	public void addProperties(Properties properties) {
		super.save(properties);
	}

	@Override
	public void updateProperties(Properties properties) {
		super.update(properties);
	}

	@Override
	public Properties getPropertiesById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deletePropertiesById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Properties condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Properties> getPropertiess(int pageNo, int pageSize, Properties condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfProperties(Properties condition) {
		return super.getCount(condition);
	}

}




