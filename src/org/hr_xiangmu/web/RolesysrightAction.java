package org.hr_xiangmu.web;

import java.util.List;

import org.hr_xiangmu.dao.rolesysrightDao;
import org.hr_xiangmu.dao.impl.RoleSysrightDaoImpl;
import org.hr_xiangmu.entity.Rolesysright;

import com.opensymphony.xwork2.ActionSupport;

public class RolesysrightAction extends ActionSupport {
	private rolesysrightDao rolerightDao = new RoleSysrightDaoImpl();
	
	private Integer roleId; //���մ��ݹ����Ľ�ɫ���

	private List<Rolesysright> rolesysRightList; //��ɫӵ�е�Ȩ�޼���
	
	private boolean result;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<Rolesysright> getRolesysRightList() {
		return rolesysRightList;
	}

	public void setRolesysRightList(List<Rolesysright> rolesysRightList) {
		this.rolesysRightList = rolesysRightList;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	/**
	 * ��ѯ��ɫӵ�е�Ȩ��
	 */
	public String search() throws Exception {
		rolesysRightList = rolerightDao.getRoleRightByRoleId(roleId);
		return "search";
	}
	
	public String assign() throws Exception {
		rolerightDao.deleteRoleRightByRoleId(roleId);
		for (Rolesysright roleRight : rolesysRightList) {
			rolerightDao.addRoleRight(roleRight);
		}
		result = true;
		return "biaoshi";
	}
	
	
}
