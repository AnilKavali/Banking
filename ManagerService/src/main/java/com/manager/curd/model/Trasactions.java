package com.manager.curd.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trasactions")
public class Trasactions {

	 
	@Id
	private int tid;
	private String cid;
	private String ttype;
	private String amount;
	private String date;
	
	public Trasactions() {
		
	}
	
	public Trasactions(int tid, String cid, String ttype, String amount, String date) {
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
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
