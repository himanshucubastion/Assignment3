package com.assign3.Assignment3.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updateAt;
	
	// setting up OneToMany relation with Assignment class
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
//						CascadeType.DETACH, CascadeType.REFRESH })

//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private List<Assignment> assign;

//	// setting up OneToMany relation with Task class
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
//						CascadeType.DETACH, CascadeType.REFRESH })
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private List<Task> task;
//
//	// setting up OneToMany relation with LineItem class
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
//						CascadeType.DETACH, CascadeType.REFRESH })
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private List<LineItem> lineItem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	public List<Assignment> getAssign() {
//		return assign;
//	}
//
//	public void setAssign(List<Assignment> assign) {
//		this.assign = assign;
//	}
	
//	public List<Task> getTask() {
//		return task;
//	}
//
//	public void setTask(List<Task> task) {
//		this.task = task;
//	}
//
//	public List<LineItem> getLineItem() {
//		return lineItem;
//	}
//
//	public void setLineItem(List<LineItem> lineItem) {
//		this.lineItem = lineItem;
//	}

	public User() {}

	public User(long id, String username, String password, String email, String firstname, String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", firstname=" + firstname + ", lastname=" + lastname  + "]";
	}
}
