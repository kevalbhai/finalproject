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
@Table(name="experience")
public class Experience {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="hospital_name")
	private String hospitalname;
	@Column(name="city")
	private String city;
	@Column(name="feedback")
	private String feedback;
	
	@ManyToMany(mappedBy="experienceList", fetch=FetchType.EAGER)
	@JsonIgnore
	List<User> usersList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public List<User> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	
	@Override
	public String toString() {
		return "Experience [id=" + id + ", hospitalname=" + hospitalname + ", city=" + city + ", feedback=" + feedback
				+ ", usersList=" + usersList + "]";
	}
	
}
