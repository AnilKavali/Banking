package com.manager.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customeraccounts")
public class CustomerAccounts {
	
	@Id
	private String accno;
	private String cid;
	private String accttype;
	private String balance;
	
	public CustomerAccounts() {
		
	}
	
	public CustomerAccounts(String accno, String cid, String accttype, String balance) {
		super();
		this.accno = accno;
		this.cid = cid;
		this.accttype = accttype;
		this.balance = balance;
	}
	
	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAccttype() {
		return accttype;
	}

	public void setAccttype(String accttype) {
		this.accttype = accttype;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	

}
