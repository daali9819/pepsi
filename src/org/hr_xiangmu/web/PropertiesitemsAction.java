package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.PropertiesitemsDao;
import org.hr_xiangmu.dao.impl.PropertiesitemsDaoImpl;
import org.hr_xiangmu.entity.Propertiesitems;

import com.opensymphony.xwork2.ActionSupport;

public class PropertiesitemsAction extends ActionSupport {
	private PropertiesitemsDao propertiesitemsDao = new PropertiesitemsDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Propertiesitems> propertiesitemsList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Propertiesitems condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Propertiesitems propertiesitems; //封装用户信息
	
	private Integer PId;

	public Integer getPId() {
		return PId;
	}

	public void setPId(Integer pId) {
		PId = pId;
	}

	public Propertiesitems getPropertiesitems() {
		return propertiesitems;
	}

	public void setPropertiesitems(Propertiesitems propertiesitems) {
		this.propertiesitems = propertiesitems;
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

	public Propertiesitems getCondition() {
		return condition;
	}

	public void setCondition(Propertiesitems condition) {
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

	public List<Propertiesitems> getPropertiesitemsList() {
		return propertiesitemsList;
	}

	public void setPropertiesitemsList(List<Propertiesitems> propertiesitemsList) {
		this.propertiesitemsList = propertiesitemsList;
	}
	
	public String search() throws Exception {
		propertiesitemsList = propertiesitemsDao.getPropertiesitemsByPId(PId);
		return "search";
	}
	
	public String list() throws Exception {
		propertiesitemsList = propertiesitemsDao.getPropertiesitemss(page, rows, condition, null, null);
		total = propertiesitemsDao.getCountOfPropertiesitems(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				propertiesitemsDao.deletePropertiesitemsById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		propertiesitemsDao.addPropertiesitems(propertiesitems);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		propertiesitems = propertiesitemsDao.getPropertiesitemsById(propertiesitems.getPropertiesItemsId());
		return "edit";
	}
	
	public String edit() throws Exception {
		propertiesitemsDao.updatePropertiesitems(propertiesitems);
		result = true;
		return "biaoshi";
	}
	
}













