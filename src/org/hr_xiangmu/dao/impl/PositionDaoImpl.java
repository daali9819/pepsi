package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.PositionDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Position;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class PositionDaoImpl extends BaseHibernateDao<Position> implements PositionDao {
	@Override
	public List<Position> getAllPositions(){
		return super.getAll();
	}
	
	@Override
	public void addPosition(Position position) {
		super.save(position);
	}

	@Override
	public void updatePosition(Position position) {
		super.update(position);
	}

	@Override
	public Position getPositionById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deletePositionById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Position condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Position> getPositions(int pageNo, int pageSize, Position condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfPosition(Position condition) {
		return super.getCount(condition);
	}

}




