﻿package org.hr_xiangmu.web;

import java.util.Date;
import java.util.List;

import org.hr_xiangmu.dao.BacklogDao;
import org.hr_xiangmu.dao.impl.BacklogDaoImpl;
import org.hr_xiangmu.entity.Backlog;

import com.opensymphony.xwork2.ActionSupport;

public class BacklogAction extends ActionSupport {
	private BacklogDao backlogDao = new BacklogDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Backlog> backlogList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Backlog condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Backlog backlog = new Backlog(); //封装用户信息

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Backlog getCondition() {
		return condition;
	}

	public void setCondition(Backlog condition) {
		this.condition = condition;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<Backlog> getBacklogList() {
		return backlogList;
	}

	public void setBacklogList(List<Backlog> backlogList) {
		this.backlogList = backlogList;
	}
	
	public String search() throws Exception {
		backlogList = backlogDao.getAllBacklogs();
		return "search";
	}
	
	public String list() throws Exception {
		backlogList = backlogDao.getBacklogs(page, rows, condition, sort, order);
		total = backlogDao.getCountOfBacklog(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				backlogDao.deleteBacklogById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		backlogDao.addBacklog(backlog);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		backlog = backlogDao.getBacklogById(backlog.getId());
		return "edit";
	}
	
	public String edit() throws Exception {
		backlogDao.updateBacklog(backlog);
		result = true;
		return "biaoshi";
	}
	
	public String addsalayitems() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				if (id != null) {
					backlog.setBacklogType("salayitems");
					backlog.setBacklogName("薪酬审核");
					backlog.setBacklogDate(new Date().toString());
					backlog.setId(id);
					backlog.setBacklogShenheren("admin");
					backlogDao.addBacklog(backlog);
				}
			}
		}
		result = true;
		return "biaoshi";
	}
}













