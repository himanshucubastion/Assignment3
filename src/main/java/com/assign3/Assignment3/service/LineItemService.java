package com.assign3.Assignment3.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign3.Assignment3.entity.LineItem;
import com.assign3.Assignment3.entity.Task;
import com.assign3.Assignment3.exception.BusinessException;
import com.assign3.Assignment3.repository.LineItemRepo;
import com.assign3.Assignment3.security.JwtTokenUtil;



@Service
public class LineItemService {
	
	@Autowired
	private LineItemRepo repo;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	

	public LineItem addLineItem(LineItem l, String token) {
		long userId =(Integer) jwtTokenUtil.getAllClaimsFromToken(token).get("user_id");
	    l.setUserId(userId);
	    Task t=taskService.getTask(l.getTaskId());
	    
	    taskService.updateTotal(t.getTotal()+ l.getAmount(), l.getTaskId());
	    return repo.save(l);
	}



	//get all Line Items
	public List<LineItem> getAllLineItem() {
		List<LineItem> lineItemList = null;
		try {
			lineItemList = repo.findAll();
		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in Service layer" + "while fetching all employees" + e.getMessage());
		}
		if (lineItemList.isEmpty())
			throw new BusinessException("604", "List is completely empty");
		return lineItemList;
	}
	
	//getLineItems by TaskID
    public List<LineItem> getLineItemsByTaskId(long taskId){
        return repo.findByTaskId(taskId);
       }
    
	//delete LineItem by id
	public void DelById(long id) {
		
		if(repo.findById(id).get()==null) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}
}
