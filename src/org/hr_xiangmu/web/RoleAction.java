package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.RoleDao;
import org.hr_xiangmu.dao.impl.RoleDaoImpl;
import org.hr_xiangmu.entity.Role;

import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {
	private RoleDao roleDao = new RoleDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<Role> roleList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private String order; //升续还是降续
	
	private String sort; //属性
	
	private Role condition; //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private Role role; //封装用户信息

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Role getCondition() {
		return condition;
	}

	public void setCondition(Role condition) {
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

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public String search() throws Exception {
		roleList = roleDao.getAllRoles();
		return "search";
	}
	
	public String getid() throws Exception {
		roleList = roleDao.getAll();
		return "getid";
	}
	
	
	public String list() throws Exception {
		roleList = roleDao.getRoles(page, rows, condition, sort, order);
		total = roleDao.getCountOfRole(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				roleDao.deleteRoleById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		roleDao.addRole(role);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		role = roleDao.getRoleById(role.getRoleId());
		return "edit";
	}
	
	public String edit() throws Exception {
		roleDao.updateRole(role);
		result = true;
		return "biaoshi";
	}
}













