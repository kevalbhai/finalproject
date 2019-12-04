package com.cognizant.bloodbank.model;

import java.util.List;
import java.util.Set;

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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {

	@Id
	@NotNull
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="age")
	private int age;
	@Column(name="blood_group")
	private String bloodgroup;
	@Column(name="gender")
	private String gender;
	@Column(name="weight")
	private int weight;
	@Column(name="contact_no")
	private long contact;
	@NotNull
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="password")
	private String password;
	@Column(name="area")
	private String area;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private int pincode;
	
	@ManyToMany()
	@JoinTable(name="user_blood_req", joinColumns=@JoinColumn(name="ubr_us_id"), inverseJoinColumns=@JoinColumn(name="ubr_br_id"))
	private List<BloodRequirement> bloodrequireList;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="ur_us_id"), inverseJoinColumns=@JoinColumn(name="ur_ro_id"))
	private Set<Role> roleList;
	
	@ManyToMany()
	@JoinTable(name="user_exp", joinColumns=@JoinColumn(name="ue_us_id"), inverseJoinColumns=@JoinColumn(name="ue_ex_id"))
	private List<Experience> experienceList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String isGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
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

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	
	public List<BloodRequirement> getBloodrequireList() {
		return bloodrequireList;
	}

	public void setBloodrequireList(List<BloodRequirement> bloodrequireList) {
		this.bloodrequireList = bloodrequireList;
	}
	
	public List<Experience> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<Experience> experienceList) {
		this.experienceList = experienceList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", bloodgroup=" + bloodgroup + ", gender=" + gender + ", weight=" + weight + ", contact=" + contact
				+ ", email=" + email + ", password=" + password + ", area=" + area + ", state=" + state + ", pincode="
				+ pincode + ", bloodrequireList=" + bloodrequireList.indexOf(1) + ", roleList=" + roleList + ", experienceList="
				+ experienceList.indexOf(1) + "]";
	}
	
	
}
