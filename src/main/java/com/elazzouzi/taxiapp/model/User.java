package com.elazzouzi.taxiapp.model;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "app_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	@Transient
	private String password;
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_ROLES", 
    			joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "id"), 
    			inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id")
    )
	private Collection<Role> roles;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
   
}

