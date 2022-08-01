package com.assign3.Assignment3.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String taskName;
    private String description;

    private Double total = 0.0;

    private Long assignId;

    private Long userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updateAt;


    @ManyToOne
    @JoinColumn(name = "assignId", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Assignment assign;

//	@OneToMany(mappedBy="task")
//	@OneToMany(fetch=FetchType.LAZY, cascade ={CascadeType.PERSIST, CascadeType.MERGE,
//						CascadeType.DETACH, CascadeType.REFRESH })

    //	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE,
//			CascadeType.DETACH, CascadeType.REFRESH })
    @OneToMany(mappedBy = "task")
    private List<LineItem> lineItem;
//	// setting up OneToMany relation with LineItem class
//	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, 
//						CascadeType.DETACH, CascadeType.REFRESH })
//	@JoinColumn(name = "task_id", referencedColumnName = "id")


    public Task() {
    }

    public Task(long id, String taskName, String description, Double total) {
        super();
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.total = total;
        //this.lineItem = lineItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignId(Long assignId) {
        this.assignId = assignId;
    }


//	
//	public Assignment getAssign() {
//		return assign;
//	}
//
//	public void setAssign(Assignment assign) {
//		this.assign = assign;
//	}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<LineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", taskName=" + taskName + ", description=" + description + ", total=" + total
                + "]";
    }
}
