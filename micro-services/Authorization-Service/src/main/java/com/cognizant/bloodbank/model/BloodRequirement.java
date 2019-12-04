package com.cognizant.bloodbank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="blood_requirement")
public class BloodRequirement {
	
	@Id
	@Column(name="br_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private int id;
	@Column(name="blood_group")
	//@NotNull
	private String bloodgroup;
	@Column(name="area")
	//@NotNull
	private String area;
	@Column(name="state")
	//@NotNull
	private String state;
	//@NotNull
	@Column(name="pincode")
	private int pincode;
	
	@ManyToMany(mappedBy="bloodrequireList", fetch=FetchType.EAGER)
	@JsonIgnore
	private List<User> userList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "BloodRequirement [id=" + id + ", bloodgroup=" + bloodgroup + ", area=" + area + ", state=" + state
				+ ", pincode=" + pincode + ", userList=" + userList + "]";
	}	
	
}
