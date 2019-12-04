package com.cognizant.bloodbank.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="role")
public class Role {

	@NotNull
	@Id
	@Column(name="ro_id")
	private int id;
	@NotNull
	@Column(name="ro_name")
	private String name;
	@ManyToMany(mappedBy="roleList", fetch=FetchType.EAGER)
	@JsonIgnore
    private Set<User> userList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	
}
