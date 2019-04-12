package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.TitleDao;
import org.hr_xiangmu.dao.impl.TitleDaoImpl;
import org.hr_xiangmu.entity.Title;

import com.opensymphony.xwork2.ActionSupport;

public class TitleAction extends ActionSupport {
	private TitleDao titleDao = new TitleDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Title> titleList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Title condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Title title; //封装用户信息

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
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

	public Title getCondition() {
		return condition;
	}

	public void setCondition(Title condition) {
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

	public List<Title> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}
	
	public String search() throws Exception {
		titleList = titleDao.getAllTitles();
		return "search";
	}
	
	public String list() throws Exception {
		titleList = titleDao.getTitles(page, rows, condition, sort, order);
		total = titleDao.getCountOfTitle(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				titleDao.deleteTitleById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		if(title.getTitleIstrue() == null){
			title.setTitleIstrue(false);
		}
		titleDao.addTitle(title);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		title = titleDao.getTitleById(title.getTitleId());
		return "edit";
	}
	
	public String edit() throws Exception {
		if(title.getTitleIstrue() == null){
			title.setTitleIstrue(false);
		}
		titleDao.updateTitle(title);
		result = true;
		return "biaoshi";
	}
}













