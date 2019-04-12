﻿package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.PropertiesDao;
import org.hr_xiangmu.dao.impl.PropertiesDaoImpl;
import org.hr_xiangmu.entity.Properties;

import com.opensymphony.xwork2.ActionSupport;

public class PropertiesAction extends ActionSupport {
	private PropertiesDao propertiesDao = new PropertiesDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Properties> propertiesList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Properties condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Properties properties; //封装用户信息

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
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

	public Properties getCondition() {
		return condition;
	}

	public void setCondition(Properties condition) {
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

	public List<Properties> getPropertiesList() {
		return propertiesList;
	}

	public void setPropertiesList(List<Properties> propertiesList) {
		this.propertiesList = propertiesList;
	}
	
	public String search() throws Exception {
		propertiesList = propertiesDao.getAllPropertiess();
		return "search";
	}
	
	public String list() throws Exception {
		propertiesList = propertiesDao.getPropertiess(page, rows, condition, sort, order);
		total = propertiesDao.getCountOfProperties(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				propertiesDao.deletePropertiesById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		propertiesDao.addProperties(properties);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		properties = propertiesDao.getPropertiesById(properties.getPropertiesId());
		return "edit";
	}
	
	public String edit() throws Exception {
		propertiesDao.updateProperties(properties);
		result = true;
		return "biaoshi";
	}
}













