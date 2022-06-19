package com.simplilearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student_19062022")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "s_id")
	private long student_id;

	@Column(name = "f_name")
	private String fname;

	@Column(name = "l_name")
	private String lname;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<PhoneNumber> phones;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course_link", joinColumns = @JoinColumn(name = "s_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<Course> course;

	@Embedded
	private Address address;

	public String getAddress() {
		if (address == null)
			return "";
		return address.getStreet() + "," + address.getCity() + "," + address.getState();
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCourse() {
		StringBuilder sb = new StringBuilder();
		if (course != null) {
			for (Course c : course) {
				sb.append(c.getCourseName() + ", ");
			}
		}
		return sb.toString();
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhones() {
		StringBuilder sb = new StringBuilder();

		if (phones != null && phones.size() > 0) {
			for (PhoneNumber phone : phones) {
				sb.append(phone.getPhoneNumber() + " ");
			}
		}
		return sb.toString();
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
}