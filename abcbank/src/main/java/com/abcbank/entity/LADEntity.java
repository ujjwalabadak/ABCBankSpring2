package com.abcbank.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="LAD")
public class LADEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lad_id;
	
	@NotBlank(message = "Status is mandatory")
	@Size(min = 3, max = 20, message = "status must be between 3 and 20   characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "status must be alphanumeric with no spaces")
	private String status;
	@NotBlank(message = "password is mandatory")
	@Size(min = 3, max = 20, message = "password must be between 3 and 20   characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "password must be alphanumeric with no spaces")
	private String password;
	@ManyToOne
	@JoinColumn(name="cust_id")
	private CustomerEntity cust;
	
	public CustomerEntity getCust() {
		return cust;
	}
	public void setCust(CustomerEntity cust) {
		this.cust = cust;
	}
	public int getLad_id() {
		return lad_id;
	}
	public void setLad_id(int lad_id) {
		this.lad_id = lad_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
