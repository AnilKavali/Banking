package com.manager.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {
	
	@Id
	private int accid;//New Field
	private String accttype;
	private String minBalance;
	private String roi;
	
	public Accounts() {
		
	}
	
	public Accounts(String accttype, String minBalance, String roi) {
		super();
		this.accttype = accttype;
		this.minBalance = minBalance;
		this.roi = roi;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public String getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(String minBalance) {
		this.minBalance = minBalance;
	}

	public String getRoi() {
		return roi;
	}

	public void setRoi(String roi) {
		this.roi = roi;
	}

	
}