package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.PositionDao;
import org.hr_xiangmu.dao.impl.PositionDaoImpl;
import org.hr_xiangmu.entity.Position;

import com.opensymphony.xwork2.ActionSupport;

public class PositionAction extends ActionSupport {
	private PositionDao positionDao = new PositionDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Position> positionList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Position condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Position position; //封装用户信息

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
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

	public Position getCondition() {
		return condition;
	}

	public void setCondition(Position condition) {
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

	public List<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<Position> positionList) {
		this.positionList = positionList;
	}
	
	public String search() throws Exception {
		positionList = positionDao.getAllPositions();
		return "search";
	}
	
	
	
	public String list() throws Exception {
		positionList = positionDao.getPositions(page, rows, condition, sort, order);
		total = positionDao.getCountOfPosition(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				positionDao.deletePositionById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		if(position.getPositionIstrue() == null){
			position.setPositionIstrue(false);
		}
		positionDao.addPosition(position);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		position = positionDao.getPositionById(position.getPositionId());
		return "edit";
	}
	
	public String edit() throws Exception {
		if(position.getPositionIstrue() == null){
			position.setPositionIstrue(false);
		}
		positionDao.updatePosition(position);
		result = true;
		return "biaoshi";
	}
}













