package org.hr_xiangmu.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.UserDao;
import org.hr_xiangmu.entity.Role;
import org.hr_xiangmu.entity.User;
import org.hr_xiangmu.utils.BaseHibernateDao;

public class UserDaoImpl extends BaseHibernateDao<User> implements UserDao {
	@Override
	public List<User> getAllUsers(){
		return super.getAll();
	}
	
	@Override
	public void addUser(User user) {
		super.save(user);
	}

	@Override
	public void updateUser(User user) {
		super.update(user);
	}

	@Override
	public User getUserById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, User condition) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("login_user");
		if(condition != null) {
			condition.setRole(currentUser.getRole());
			if (condition.getRole().getRoleId() == 1) {
				
			} else {
				criteria.add(Restrictions.gt("role.roleId", 1));
			}
		}
	}

	@Override
	public List<User> getUsers(int pageNo, int pageSize, User condition) {
//		Session session1 = super.getSession();
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpSession session = request.getSession();
//		User currentUser = (User) session.getAttribute("login_user");
//		condition.setRole(currentUser.getRole());
//		String hql;
//		if (condition.getRole().getRoleId() == 1) {
//			hql = "from User";
//		} else {
//			hql = "from User u where u.role.roleId > 1";
//		}
//		Query query = session1.createQuery(hql);
		return super.getPageList(pageNo, pageSize, condition);
	}

	@Override
	public Integer getCountOfUser(User condition) {
		return super.getCount(condition);
	}
	
	/**
	 * 鐧诲綍
	 */
	@Override
	public User loginCheck(String username, String password) {
		Session session = super.getSession();
		String hql = "from User where userUsername = :username and userPassword = :password";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		query.setString("password", password);
		return (User) query.uniqueResult();
	}
	
	/**
	 * 淇敼瀵嗙爜
	 */
	@Override
	public void updpwd(String password,int id) {
		Session session = super.getSession();
		String hql = "update User set userPassword = :password where userId = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		query.setString("password", password);
		query.executeUpdate();
	}

}




