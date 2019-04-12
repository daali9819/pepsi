package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hr_xiangmu.dao.RoleDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class RoleDaoImpl extends BaseHibernateDao<Role> implements RoleDao {
	
	@Override
	public List<Role> getAll() {
		return super.getAll();
	}
	
	@Override
	public List<Role> getAllRoles(){
		return super.getAll();
	}
	
	@Override
	public void addRole(Role role) {
		super.save(role);
	}

	@Override
	public void updateRole(Role role) {
		super.update(role);
	}

	@Override
	public Role getRoleById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteRoleById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Role condition) {
		if(condition != null) {
			
		}
	}

	@Override
	public List<Role> getRoles(int pageNo, int pageSize, Role condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfRole(Role condition) {
		return super.getCount(condition);
	}

}




