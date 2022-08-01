package com.assign3.Assignment3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign3.Assignment3.entity.AssignDto;
import com.assign3.Assignment3.entity.AssignDto;
import com.assign3.Assignment3.entity.Assignment;
import com.assign3.Assignment3.exception.BusinessException;
import com.assign3.Assignment3.repository.AssignDtoRepo;
import com.assign3.Assignment3.repository.AssignmentRepo;
import com.assign3.Assignment3.security.JwtTokenUtil;

@Service
public class AssignmentService {
	
	@Autowired
	private AssignmentRepo repo;
	
	@Autowired AssignDtoRepo dtoRepo;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	//add assignment
	public Assignment addAssign(Assignment a, String token) {
		long userId =(Integer) jwtTokenUtil.getAllClaimsFromToken(token).get("user_id");
	    a.setUserId(userId);
	    return repo.save(a);	    
	}


	public List<Assignment> getAllAssignment() {
		return repo.findAll();
	}

//	//get all assignment
//	public List<Assignment> getAllAssignment() {
//		List<Assignment> AssignList = null;
//		try {
//			AssignList = repo.findAllAssign();
//		} catch (Exception e) {
//			throw new BusinessException("605",
//					"Something went wrong in Service layer" + "while fetching all employees" + e.getMessage());
//		}
//		if (AssignList.isEmpty())
//			throw new BusinessException("604", "List is completely empty");
//		return AssignList;
//	}
//
//
	
	// get by id
	public List<Assignment> getAssignByUserId(long userId) {
        return repo.findByUserId(userId);
	  }
	
	public List<AssignDto> getAllAssignDto() {
		
		return repo.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	private AssignDto convertEntityToDto(Assignment assign) {
		AssignDto assignDto=new AssignDto();
		
		assignDto.setAssignId(assign.getId());
		assignDto.setAssignName(assign.getAssignName());
		assignDto.setUserId(assign.getUserId());
//		assignDto.setTaskId(assign.getTask().get(0).getId());
//		assignDto.setTaskName(assign.getTask().get(0).getTaskName());
//		assignDto.setDescription(assign.getTask().get(0).getDescription());
//		assignDto.setTotal(assign.getTask().get(0).getTotal());
		
		return assignDto;
		
	}


}

