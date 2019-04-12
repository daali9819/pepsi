package org.hr_xiangmu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hr_xiangmu.dao.RoleDao;
import org.hr_xiangmu.dao.rolesysrightDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.Rolesysright;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class RoleSysrightDaoImpl extends BaseHibernateDao<Rolesysright>
		implements rolesysrightDao {

	@Override
	public void addRoleRight(Rolesysright rolesysRight) {
		super.save(rolesysRight);
		
	}

	@Override
	public List<Rolesysright> getRoleRightByRoleId(Integer roleId) {
		Session session = super.getSession();
		String hql = "from Rolesysright where role.roleId = :roleId";
		Query query = session.createQuery(hql);
		query.setInteger("roleId", roleId);
		return query.list();
	}

	@Override
	public void deleteRoleRightByRoleId(Integer roleId) {
		Session session = super.getSession();
		String hql = "delete from Rolesysright where role.roleId = :roleId";
		Query query = session.createQuery(hql);
		query.setInteger("roleId", roleId);
		query.executeUpdate();
	}

	

}
