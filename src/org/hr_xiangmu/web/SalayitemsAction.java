﻿package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.SalayitemsDao;
import org.hr_xiangmu.dao.impl.SalayitemsDaoImpl;
import org.hr_xiangmu.entity.Salayitems;

import com.opensymphony.xwork2.ActionSupport;

public class SalayitemsAction extends ActionSupport {
	private SalayitemsDao salayitemsDao = new SalayitemsDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Salayitems> salayitemsList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Salayitems condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Salayitems salayitems; //封装用户信息

	public Salayitems getSalayitems() {
		return salayitems;
	}

	public void setSalayitems(Salayitems salayitems) {
		this.salayitems = salayitems;
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

	public Salayitems getCondition() {
		return condition;
	}

	public void setCondition(Salayitems condition) {
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

	public List<Salayitems> getSalayitemsList() {
		return salayitemsList;
	}

	public void setSalayitemsList(List<Salayitems> salayitemsList) {
		this.salayitemsList = salayitemsList;
	}
	
	public String search() throws Exception {
		salayitemsList = salayitemsDao.getAllSalayitemss();
		return "search";
	}
	
	public String list() throws Exception {
		salayitemsList = salayitemsDao.getSalayitemss(page, rows, condition, null, null);
		total = salayitemsDao.getCountOfSalayitems(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				salayitemsDao.deleteSalayitemsById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		salayitems.setSalayitemsState("起草");
		salayitemsDao.addSalayitems(salayitems);
		result = true;
		return "biaoshi";
	}

	public String addshenhe() throws Exception {
		salayitems.setSalayitemsState("审核中");
		salayitemsDao.addSalayitems(salayitems);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		salayitems = salayitemsDao.getSalayitemsById(salayitems.getSalayitemsId());
		return "edit";
	}
	
	public String edit() throws Exception {
		salayitemsDao.updateSalayitems(salayitems);
		result = true;
		return "biaoshi";
	}
}













