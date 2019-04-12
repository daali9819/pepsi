package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.User;

public interface UserDao {
	/**
	 * 修改密码
	 * @param password
	 * @param id
	 */
	public void updpwd(String password,int id);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User loginCheck(String username, String password);
	
	public List<User> getAllUsers();
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUserById(Integer id);
	
	public void deleteUserById(Integer id);
	
	public List<User> getUsers(int pageNo, int pageSize, User condition);
	
	public Integer getCountOfUser(User condtion);
}











