package org.hr_xiangmu.web;

import java.util.List;
import java.util.Map;

import org.hr_xiangmu.dao.UserDao;
import org.hr_xiangmu.dao.impl.UserDaoImpl;
import org.hr_xiangmu.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserDao userDao = new UserDaoImpl();
	
	private Integer total; //总数据条数
	
	private List<User> userList; //用户列表
	
	private Integer page; //当前页
	
	private Integer rows; //每页显示的数据条数
	
	private User condition = new User(); //封装查询条件
	
	private List<Integer> ids; //要删除的记录编号集合
	
	private Boolean result = false; //标示属性
	
	private User user; //封装用户信息

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public User getCondition() {
		return condition;
	}

	public void setCondition(User condition) {
		this.condition = condition;
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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String search() throws Exception {
		userList = userDao.getAllUsers();
		return "search";
	}
	
	public String list() throws Exception {
		userList = userDao.getUsers(page, rows, condition);
		total = userDao.getCountOfUser(condition);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		if(ids != null) {
			for (Integer id : ids) {
				userDao.deleteUserById(id);
			}
		}
		result = true;
		return "biaoshi";
	}
	
	public String add() throws Exception {
		userDao.addUser(user);
		result = true;
		return "biaoshi";
	}
	
	public String toedit() throws Exception {
		user = userDao.getUserById(user.getUserId());
		return "edit";
	}
	
	public String edit() throws Exception {
		userDao.updateUser(user);
		result = true;
		return "biaoshi";
	}

	public String login() throws Exception {
		User u = userDao.loginCheck(user.getUserUsername(), user.getUserPassword());
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(u != null) {
			session.put("login_user", u);
			return "loginSuccess";
		}
		session.put("err", "用户名或者密码错误");
		return LOGIN;
	}
	
	/**
	 * 修改密码
	 */
	public String updpwd() throws Exception {
		userDao.updpwd(user.getUserPassword(), user.getUserId());
		return "updpwdsuccess";
	}
}













