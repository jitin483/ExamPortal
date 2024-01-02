package com.exampotal.models;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name="roles")
public class Role {
    @Id
    private Long roleid;
    private String roleName;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy="role")
    @JsonIgnore
    Set<UserRole> userRole=new HashSet<UserRole>();
    
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	public Role(Long roleid, String roleName, Set<UserRole> userRole) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
		this.userRole = userRole;
	}
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
    
  
}

