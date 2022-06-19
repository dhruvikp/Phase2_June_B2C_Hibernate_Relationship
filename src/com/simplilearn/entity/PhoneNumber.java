package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phone_19062022")
public class PhoneNumber {

	@Id
	@GeneratedValue
	@Column(name="p_id")
	private long phoneNumberId;
	
	@Column(name="p_type")
	private String phoneType;
	
	@Column(name="p_number")
	private String phoneNumber;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="s_id")
	private Student student;

	public long getPhoneNumberId() {
		return phoneNumberId;
	}

	public void setPhoneNumberId(long phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
