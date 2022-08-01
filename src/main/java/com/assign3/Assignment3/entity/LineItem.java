package com.assign3.Assignment3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="lineItem")
public class LineItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String lineItemName;
	private String l_desc;
	private double amount;
	
	private long taskId;
	private long userId;
	
	@ManyToOne
	@JoinColumn(name="taskId", insertable=false, updatable=false)
	private Task task;
	@Fetch(FetchMode.JOIN)
	
	
	
//	public Task getTask() {
//		return task;
//	}
//	public void setTask(Task task) {
//		this.task = task;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLineItemName() {
		return lineItemName;
	}
	public void setLineItemName(String lineItemName) {
		this.lineItemName = lineItemName;
	}
	public String getL_desc() {
		return l_desc;
	}
	public void setL_desc(String l_desc) {
		this.l_desc = l_desc;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public LineItem() {}
	
	public LineItem(long id, String lineItemName, String l_desc, Double amount) {
		super();
		this.id = id;
		this.lineItemName = lineItemName;
		this.l_desc = l_desc;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "LineItem [id=" + id + ", lineItemName=" + lineItemName + ", l_desc=" + l_desc + ", amount=" + amount
				+ "]";
	}
}
