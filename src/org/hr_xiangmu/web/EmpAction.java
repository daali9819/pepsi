﻿package org.hr_xiangmu.web;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hr_xiangmu.dao.EmpDao;
import org.hr_xiangmu.dao.impl.EmpDaoImpl;
import org.hr_xiangmu.dao.impl.TitleDaoImpl;
import org.hr_xiangmu.entity.Emp;

import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	private EmpDao empDao = new EmpDaoImpl();
	private TitleDaoImpl tdl = new TitleDaoImpl();
	
	private Integer total; //总数据条数
	 
	private List<Emp> empList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Emp condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Emp emp; //封装用户信息
	
	private File empAccessory;
	
	private String empAccessoryFileName;
	
	private File empPhoto;
	
	private String empPhotoFileName;
	
	
	

	public String getEmpPhotoFileName() {
		return empPhotoFileName;
	}

	public void setEmpPhotoFileName(String empPhotoFileName) {
		this.empPhotoFileName = empPhotoFileName;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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

	public Emp getCondition() {
		return condition;
	}

	public void setCondition(Emp condition) {
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

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	
	public String search() throws Exception {
		empList = empDao.getAllEmps();
		return "search";
	}
	
	public String cha() throws Exception{
		empList = empDao.getEmpBycondtion(condition);
		return "cha";
		
	}
	
	public String list() throws Exception {
		empList = empDao.getEmps(page, rows, condition, sort, order);
		total = empDao.getCountOfEmp(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				empDao.deleteEmpById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		if (empPhoto != null) {
			String realPath=ServletActionContext.getServletContext().getRealPath("/sys/imgs");
			File dest= new File(realPath + File.separator+ empPhotoFileName);	
			FileUtils.copyFile(empPhoto, dest);
			emp.setEmpPhoto("sys/imgs/"+empPhotoFileName);
		}
		if (empAccessory != null) {
			String realPath=ServletActionContext.getServletContext().getRealPath("/sys/Accessory");
			File two= new File(realPath + File.separator+ empAccessoryFileName);
			FileUtils.copyFile(empAccessory, two);
			emp.setEmpAccessory("sys/imgs/"+empAccessoryFileName);
		}
		empDao.addEmp(emp);
			result = true;
		return "biaoshi";
	}
	
	public File getEmpAccessory() {
		return empAccessory;
	}

	public void setEmpAccessory(File empAccessory) {
		this.empAccessory = empAccessory;
	}

	public String getEmpAccessoryFileName() {
		return empAccessoryFileName;
	}

	public void setEmpAccessoryFileName(String empAccessoryFileName) {
		this.empAccessoryFileName = empAccessoryFileName;
	}

	public File getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(File empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String toedit() throws Exception {
		emp = empDao.getEmpById(emp.getEmpId());
		return "edit";
	}
	
	public String edit() throws Exception {
		if (empPhoto != null) {
			String realPath=ServletActionContext.getServletContext().getRealPath("/sys/imgs");
			File dest= new File(realPath + File.separator+ empPhotoFileName);	
			FileUtils.copyFile(empPhoto, dest);
			emp.setEmpPhoto("sys/imgs/"+empPhotoFileName);
		}
		if (empAccessory != null) {
			String realPath=ServletActionContext.getServletContext().getRealPath("/sys/Accessory");
			File two= new File(realPath + File.separator+ empAccessoryFileName);
			FileUtils.copyFile(empAccessory, two);
			emp.setEmpAccessory("sys/imgs/"+empAccessoryFileName);
		}
		empDao.updateEmp(emp);
		result = true;
		return "biaoshi";
	}
}













