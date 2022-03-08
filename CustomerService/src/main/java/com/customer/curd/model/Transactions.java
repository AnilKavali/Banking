package com.customer.curd.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	
    private int tid;
    private int cid;
    private String ttype;
    private double amount;
    private String date;
    
	public Transactions() {
		
	}
	
	public Transactions(int tid, int cid, String ttype, double amount, String date) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.ttype = ttype;
		this.amount = amount;
		this.date = date;
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
    

}
