package org.hr_xiangmu.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

public class BaseHibernateDao<T> {
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	/**
	 * 获取泛型的真实类�?
	 */
	public Class getGenericClass(){
		//获取父类的泛型类�?
		Type type = super.getClass().getGenericSuperclass();
		//判断是否使用了泛�?
		if(!(type instanceof ParameterizedType)){
			return Object.class;
		}
		//获取泛型的真实类�?
		ParameterizedType t = (ParameterizedType)type;
		Type[] types = t.getActualTypeArguments();
		return (Class)types[0];
	}
	
	
	/**
	 * 添加对象
	 * @param object
	 * @return
	 */
	public Serializable save(T object){
		Session session = HibernateSessionFactory.getSession();
		Serializable id = session.save(object);
		return id;
	}
	
	/**
	 * 修改对象
	 * @param object
	 */
	public void update(T object){
		Session session = HibernateSessionFactory.getSession();
		session.update(object);
	}
	
	//Short Integer Long String  --> 接口
	public void delete(Serializable id){
		Session session = HibernateSessionFactory.getSession();
		Object o = session.get(getGenericClass(), id);
		if(o != null){
			session.delete(o);
		}
	}
	
	public T get(Serializable id) {
		Session session = HibernateSessionFactory.getSession();
		Object o = session.get(getGenericClass(), id);
		return (T)o;
	}
	
	public List<T>  getAll(){
		Session session = HibernateSessionFactory.getSession();
		String hql = "from " + getGenericClass().getSimpleName();
		Query query = session.createQuery(hql);
		List list = query.list();
		return list;
	}
	
	public List<T>  getPageList(int pageNo, int pageSize){
		Session session = HibernateSessionFactory.getSession();
		String hql = "from " + getGenericClass().getSimpleName();
		Query query = session.createQuery(hql);
		
		//设置分页
		query.setFirstResult((pageNo-1) * pageSize);
		query.setMaxResults(pageSize);
		
		List list = query.list();
		return list;
	}
	
	/**
	 * 判断 拼接 hql语句
	 * @param condition
	 * @return
	 */
	public void setCondition(Criteria criteria,T condition){
	}
	public List<T>  getPageList(int pageNo, int pageSize, T condition){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(getGenericClass());
		
		//设置条件
		setCondition(criteria, condition);
		
		//设置分页
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	public List<T>  getPageList(int pageNo, int pageSize, T condition, String propertyName, String orderBy){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(getGenericClass());
		
		//设置条件
		setCondition(criteria, condition);
		
		//添加排序
		if(orderBy != null){
			if(orderBy.equals("asc")) {
				criteria.addOrder(Order.asc(propertyName));
			}else{
				criteria.addOrder(Order.desc(propertyName));
			}
		}
		
		
		//设置分页
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
	
	public Integer getCount(T condition){
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(getGenericClass());
		
		//设置条件
		setCondition(criteria, condition);
		criteria.setProjection(Projections.rowCount());
		
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	public Integer getCount(){
		Session session = HibernateSessionFactory.getSession();
		String hql = "select count(e) from "+getGenericClass().getSimpleName()+" e";
		Query query = session.createQuery(hql);
		Integer totalCount = Integer.parseInt(query.uniqueResult().toString());
		return totalCount;
	}
}












