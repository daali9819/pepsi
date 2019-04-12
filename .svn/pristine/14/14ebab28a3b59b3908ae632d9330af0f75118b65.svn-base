package org.hr_xiangmu.test;

import java.util.Date;
import java.util.List;

import org.hr_xiangmu.dao.BacklogDao;
import org.hr_xiangmu.dao.EmpDao;
import org.hr_xiangmu.dao.impl.BacklogDaoImpl;
import org.hr_xiangmu.dao.impl.EmpDaoImpl;
import org.hr_xiangmu.entity.Backlog;

public class Test {
	public static void main(String[] args) {
//		EmpDao empDao = new EmpDaoImpl();
//		List<Date> list = empDao.getEmpfilingDates();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		//String hqlString = "select o.name,count(e)  from Organization o left join o.emps e where o.parent.id=1";
	
		BacklogDao bd = new BacklogDaoImpl();
		Backlog backlog = new Backlog();
		backlog.setBacklogType("salayitems");
		backlog.setBacklogName("薪酬审核");
		backlog.setBacklogDate("2014-01-01");
		backlog.setId(1);
		backlog.setBacklogShenheren("admin");
		bd.addBacklog(backlog);
	}
}
