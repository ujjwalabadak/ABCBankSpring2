package com.abcbank.entity;




import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;



@Entity
@Table(name="admin")
public class AdminEntity {
	@Id
	private Long loanID;

	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 20, message = "Username must be between 3 and 20   characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces")
	private String name;
	private String typeofloan;
	
	@PositiveOrZero(message = "You cannot have negative rate of interest.") 
	private double rateofinterest;
	
	@Min(value=50000, message="income must be equal to or greater than 50000")
	private double income;
	@PositiveOrZero(message = "You cannot have negative duration.") 
	private int duration;
	
	
	public Long getLoanID() {
		return loanID;
	}
	public void setLoanID(Long loanID) {
		this.loanID = loanID;
	}
	public String getTypeofloan() {
		return typeofloan;
	}
	public void setTypeofloan(String typeofloan) {
		this.typeofloan = typeofloan;
	}
	public double getRateofinterest() {
		return rateofinterest;
	}
	public void setRateofinterest(double rateofinterest) {
		this.rateofinterest = rateofinterest;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
	

}





