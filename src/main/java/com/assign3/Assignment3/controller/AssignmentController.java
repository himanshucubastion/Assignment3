package com.assign3.Assignment3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assign3.Assignment3.entity.AssignDto;
import com.assign3.Assignment3.entity.Assignment;
import com.assign3.Assignment3.entity.Task;
import com.assign3.Assignment3.entity.User;
import com.assign3.Assignment3.security.JwtTokenUtil;
import com.assign3.Assignment3.service.AssignmentService;

@RestController
@RequestMapping("/assign")
public class AssignmentController {

	@Autowired
	private AssignmentService service;
	
	@Autowired
	private JwtTokenUtil jwtToken;

	
	@PostMapping("/add")
	public Assignment addAssign(@RequestBody Assignment a, @RequestHeader("token") String token) {
		return service.addAssign(a,token);
	}
	
	//Retrieve all Assignment
	@GetMapping("/get")
	public ResponseEntity<List<Assignment>> getAllAssignment() {
		List<Assignment> listAssign=service.getAllAssignment();
		return new ResponseEntity<List<Assignment>>(listAssign,HttpStatus.OK);
	}
	
	//Retrieve an Assignment with Task and Line Items
	@GetMapping("/getDto")
	public ResponseEntity<List<AssignDto>> getAllAssignDto() {
		List<AssignDto> listAssign=service.getAllAssignDto();
		return new ResponseEntity<List<AssignDto>>(listAssign,HttpStatus.OK);
	}
	
	//get AssignItems by UserId
    @GetMapping("/getByUserId")
    public List<Assignment> getAssignByUserId(@RequestParam("id") long userId) {
           return service.getAssignByUserId(userId);
       }
	
//	//Retrieve all users
//	@GetMapping("/get")
//	public ResponseEntity<List<Assignment>> getAllAssignment() {
//		List<Assignment> listAssign=service.getAllAssignment();
//		return new ResponseEntity<List<User>>(listUser,HttpStatus.OK);
//	}
//	
//	//Retrieve by an user by id
//		@GetMapping("/get/{id}")
//		public ResponseEntity<?> GetUserById(@PathVariable long id) {
//			User u=service.GetUserById(id);
//			return new ResponseEntity<User>(u,HttpStatus.OK);
//		}
//		
		//Delete an user by Id
//		@DeleteMapping("/delete")
//		public ResponseEntity<Void> DelById(@PathVariable long id){
//			service.DelById(id);
//			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//
//		}
		
		//update user detail
//		@PutMapping("/update/{id}")
//		public ResponseEntity<Auth> updateAuth(@PathVariable long id, @RequestBody Auth auth) {
	//
//			return new ResponseEntity<Auth>(service.updateAuth(auth,id), HttpStatus.OK);
//		}
		
//		   @PutMapping("/update")
//		    public User updateAssignment(@RequestBody Assignment a,@RequestHeader("token") String token) {
//		        return service.updateUser(a,token);
//		    }
		
	
}
