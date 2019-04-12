package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.SysrightDao;
import org.hr_xiangmu.dao.impl.SysrightDaoImpl;
import org.hr_xiangmu.entity.Sysright;

import com.opensymphony.xwork2.ActionSupport;

public class SysrightAction extends ActionSupport {
	private SysrightDao sysrightDao = new SysrightDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Sysright> sysrightList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Sysright condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Sysright sysright; //封装用户信息

	public Sysright getSysright() {
		return sysright;
	}

	public void setSysright(Sysright sysright) {
		this.sysright = sysright;
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

	public Sysright getCondition() {
		return condition;
	}

	public void setCondition(Sysright condition) {
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

	public List<Sysright> getSysrightList() {
		return sysrightList;
	}

	public void setSysrightList(List<Sysright> sysrightList) {
		this.sysrightList = sysrightList;
	}
	
	public String search() throws Exception {
		sysrightList = sysrightDao.getAllSysrights();
		return "search";
	}
	
	public String list() throws Exception {
		sysrightList = sysrightDao.getSysrights(1, Integer.MAX_VALUE, condition);
		total = sysrightDao.getCountOfSysright(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				sysrightDao.deleteSysrightById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		if(sysright.getParent().getSysrightId() == -1){
			sysright.setParent(null);
		}
		sysrightDao.addSysright(sysright);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		sysright = sysrightDao.getSysrightById(sysright.getSysrightId());
		return "edit";
	}
	
	public String edit() throws Exception {
		sysrightDao.updateSysright(sysright);
		result = true;
		return "biaoshi";
	}
	
	public String getfu() throws Exception {
		sysrightList = sysrightDao.sysrights();
		return "getfu";
	}
	
	
}













