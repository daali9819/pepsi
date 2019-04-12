package org.hr_xiangmu.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "hr_project")
public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private String role_miaoshu;
	
	
	
	public String getRole_miaoshu() {
		return role_miaoshu;
	}
	@Column(name = "role_miaoshu", nullable = true, length = 50)
	public void setRole_miaoshu(String role_miaoshu) {
		this.role_miaoshu = role_miaoshu;
	}

	private List<Rolesysright> rolesysrights = new ArrayList<Rolesysright>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName) {
		this.roleName = roleName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", nullable = false, length = 50)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(mappedBy = "role")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Rolesysright> getRolesysrights() {
		return this.rolesysrights;
	}

	public void setRolesysrights(List<Rolesysright> rolesysrights) {
		this.rolesysrights = rolesysrights;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}