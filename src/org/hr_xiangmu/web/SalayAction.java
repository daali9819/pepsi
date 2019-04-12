package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.SalayDao;
import org.hr_xiangmu.dao.impl.SalayDaoImpl;
import org.hr_xiangmu.entity.Salay;

import com.opensymphony.xwork2.ActionSupport;

public class SalayAction extends ActionSupport {
	private SalayDao salayDao = new SalayDaoImpl();
	
	private Integer total; //鎬绘暟鎹潯鏁�
	
	private List<Salay> salayList; //鐢ㄦ埛鍒楄〃
	
	private Integer page; //褰撳墠椤�
	
	private Integer rows; //姣忛〉鏄剧ず鐨勬暟鎹潯鏁�
	
	private String order; //鍗囩画杩樻槸闄嶇画
	
	private String sort; //灞炴�
	
	private Salay condition; //灏佽鏌ヨ鏉′欢
	
	private List<Integer> ids; //瑕佸垹闄ょ殑璁板綍缂栧彿闆嗗悎
	
	private Boolean result = false; //鏍囩ず灞炴�
	
	private Salay salay; //灏佽鐢ㄦ埛淇℃伅

	public Salay getSalay() {
		return salay;
	}

	public void setSalay(Salay salay) {
		this.salay = salay;
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

	public Salay getCondition() {
		return condition;
	}

	public void setCondition(Salay condition) {
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

	public List<Salay> getSalayList() {
		return salayList;
	}

	public void setSalayList(List<Salay> salayList) {
		this.salayList = salayList;
	}
	
	public String search() throws Exception {
		salayList = salayDao.getAllSalays();
		return "search";
	}
	
	public String list() throws Exception {
		salayList = salayDao.getSalays(page, rows, condition, sort, order);
		total = salayDao.getCountOfSalay(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				salayDao.deleteSalayById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		salayDao.addSalay(salay);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		salay = salayDao.getSalayById(salay.getSalayId());
		return "edit";
	}
	
	public String edit() throws Exception {
		salayDao.updateSalay(salay);
		result = true;
		return "biaoshi";
	}
	
	public String getAll() throws Exception {
		salayList = salayDao.getAllSalays();
		return "getAll";
	}
}













