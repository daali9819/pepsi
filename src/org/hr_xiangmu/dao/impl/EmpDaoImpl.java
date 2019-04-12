package org.hr_xiangmu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hr_xiangmu.dao.EmpDao;
import org.hr_xiangmu.entity.Emp;
import org.hr_xiangmu.entity.Orgenization;
import org.hr_xiangmu.utils.BaseHibernateDao;
import org.hr_xiangmu.utils.HibernateSessionFactory;

public class EmpDaoImpl extends BaseHibernateDao<Emp> implements EmpDao {
	@Override
	public List<Emp> getAllEmps(){
		return super.getAll();
	}
	
	@Override
	public void addEmp(Emp emp) {
		super.save(emp);
	}

	@Override
	public void updateEmp(Emp emp) {
		super.update(emp);
	}

	@Override
	public Emp getEmpById(Integer id) {
		return super.get(id);
	}

	@Override
	public void deleteEmpById(Integer id) {
		super.delete(id);
	}
	
	@Override
	public void setCondition(Criteria criteria, Emp condition) {
		if(condition != null) {
			Integer emp= condition.getEmpId();
			if(emp != null ) {
				criteria.add(Restrictions.eq("empId", emp));
			}
			String name = condition.getEmpName();
			if (name != null) {
				criteria.add(Restrictions.ilike("empName", name, MatchMode.ANYWHERE));
			}
			Orgenization o = condition.getOrgenization();
			if (o != null) {
				Integer oid = condition.getOrgenization().getOrgenizationId();
				if (oid != null) {
					criteria.add(Restrictions.eq("orgenization.orgenizationId", oid));
				}
				
			}
			
			String empState = condition.getEmpState();
			if (empState != null && !empState.equals("")) {
				criteria.add(Restrictions.eq("empState", empState));
			}
			String empNewstate = condition.getEmpNewstate();
			if (empNewstate != null && !empNewstate.equals("")) {
				criteria.add(Restrictions.eq("empNewstate", empNewstate));
			}
			
			Date starttime = condition.getStarttime();
			Date endtime = condition.getEndtime();
			if(starttime!=null && endtime!=null){
				criteria.add(Restrictions.between("empFilingDate", starttime, endtime));
			}

		}
	}
	
	@Override
	public List<Emp> getEmps(int pageNo, int pageSize, Emp condition,
			String propertyName, String orderBy) {
		return super.getPageList(pageNo, pageSize, condition, propertyName, orderBy);
	}

	@Override
	public Integer getCountOfEmp(Emp condition) {
		return super.getCount(condition);
	}

	@Override
	public List<Emp> getEmpBycondtion(Emp condtion) {
		Session session = HibernateSessionFactory.getSession();
		String hql="from emp where empFilingDate between '"+condtion.getStarttime()+"'and'"+condtion.getEndtime()+"'";
		Query query=session.createQuery(hql);
		List<Emp> list=query.list();
		return list;
	}
	
	/**
	 * 鏌ヨ鑱屽憳鍏ヨ亴鐨勬墍鏈夊勾搴�
	 */
	@Override
	public List<Date> getEmpfilingDates() {
		Session session = super.getSession();
		String sql = "select year(empFilingDate) from Emp group by(year(empFilingDate)) order by(year(empFilingDate)) desc";
		Query query = session.createQuery(sql);
		return query.list();
	}
	
}




