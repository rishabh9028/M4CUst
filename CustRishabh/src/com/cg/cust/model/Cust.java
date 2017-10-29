package com.cg.cust.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cust")
@NamedQueries({
@NamedQuery(name = "getAllCustomers", query = "SELECT cust FROM Cust cust"),
@NamedQuery(name = "getCustomerIds", query = "SELECT custId FROM Cust cust"),
@NamedQuery(name = "deleteCustomerById",  query = "DELETE FROM Cust cust WHERE cust.custId=:cId")})  

public class Cust {
	@Id
	@Column(name="cust_id")
	@Min(value=1,message="Please enter valid Value")
	@NotNull(message="Please enter your ID")
	private int custId;
	
	@Column(name="cust_name")
	@Pattern(regexp="[A-Z]{1}[a-z]{2,19}")
	@NotEmpty(message="Please enter your Name")
	private String custName;

	@Column(name="mobile_no")
	@NotNull(message="Please enter your Mobile Number")
	@Length(min=10,max=10,message="Please enter valid Mobile Number")

	private String mobile;

	@Column(name="email")
	@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message="Please enter valid Email")
	@NotEmpty(message="Please enter your Email ID")
	private String email;

	@Column(name="dateofbirth")
	@NotNull(message="Please enter your Date of Birth")
	@Past
	private Date birthDate ;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
	
}
