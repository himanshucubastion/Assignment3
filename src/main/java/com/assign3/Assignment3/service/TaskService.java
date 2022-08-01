package com.assign3.Assignment3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.assign3.Assignment3.entity.LineItem;
import com.assign3.Assignment3.entity.Task;
import com.assign3.Assignment3.exception.BusinessException;
//import com.assign3.Assignment3.repository.LineItemRepo;
import com.assign3.Assignment3.repository.TaskRepo;
import com.assign3.Assignment3.security.JwtTokenUtil;

@Service
public class TaskService {
	@Autowired
	private TaskRepo repo;
	
//	@Autowired
//	private LineItemRepo item_repo;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	//adding a new Task
	public Task addTask(Task t, String token) {
		long userId =(Integer) jwtTokenUtil.getAllClaimsFromToken(token).get("user_id");
	    t.setUserId(userId);
	    
	  //  t.setTotal(item_repo.findById(lineItem.getId()));
	    
	    return repo.save(t);	    
	}
	
	public Task getTask(Long taskId) {
		return repo.findById(taskId).orElse(null);
	}
	
	public Task updateTotal(Double total, Long taskId) {
		Task t=repo.findById(taskId).orElse(null);
		t.setTotal(total);
		return repo.save(t);
	}
	
	
	//retrieving all Tasks
	public List<Task> getAllTask() {
		List<Task> taskList = null;
		try {
			taskList = repo.findAll();
		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in Service layer" + "while fetching all employees" + e.getMessage());
		}
		if (taskList.isEmpty())
			throw new BusinessException("604", "List is completely empty");
		return taskList;
	}

	//find by id
	public List<Task> getTasksByAssignId(long assignId) {
	        return repo.findByAssignId(assignId);
	  }
}
