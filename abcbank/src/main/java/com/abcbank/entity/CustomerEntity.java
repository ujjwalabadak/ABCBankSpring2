package com.abcbank.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;




@Entity
@Table(name="customer")
public class CustomerEntity {

	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20   characters long.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String name;
	private String address;
	private long contact;
	@PositiveOrZero(message = "You cannot have negative loan_id.")
	private int loan_id;
	@NotBlank(message = "type of loan is mandatory")
	private String type_of_loan;
	@Min(value=50000, message="income must be equal to or greater than 50000")
	@PositiveOrZero(message = "You cannot have negative income.")
	private long income;
	private long acc_no;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private long cust_id;
	
	@OneToMany(mappedBy="cust",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<LADEntity> lad;
	
	
	public List<LADEntity> getLad() {
		return lad;
	}
	public void setLad(List<LADEntity> lad) {
		this.lad = lad;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public int getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}
	public String getType_of_loan() {
		return type_of_loan;
	}
	public void setType_of_loan(String type_of_loan) {
		this.type_of_loan = type_of_loan;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public long getCust_id() {
		return cust_id;
	}
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}
	
}
