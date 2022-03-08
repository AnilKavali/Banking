package com.customer.curd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	
    private String accttype;
    private int deposit;
    private Double mainbalance;
    private Double roi;
    
	public String getAccttype() {
		return accttype;
	}
	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Double getMainbalance() {
		return mainbalance;
	}
	public void setMainbalance(Double mainbalance) {
		this.mainbalance = mainbalance;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
		this.roi = roi;
	}
    
    
}
