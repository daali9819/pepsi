package org.hr_xiangmu.dao;

import java.util.List;

import org.hr_xiangmu.entity.Rolesysright;

public interface rolesysrightDao {
	
	//���Ȩ��
	public void addRoleRight(Rolesysright roleRight);

	//���ݽ�ɫ��Ų�ѯ��ӵ�е�����Ȩ��
	public List<Rolesysright> getRoleRightByRoleId(Integer roleId);
	
	
	//���ݽ�ɫ���ɾ�����µ�����Ȩ��
	public void deleteRoleRightByRoleId(Integer roleId);
	
	
}
