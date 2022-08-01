package com.assign3.Assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assign3.Assignment3.entity.LineItem;
import com.assign3.Assignment3.entity.Task;
import com.assign3.Assignment3.security.JwtTokenUtil;
import com.assign3.Assignment3.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@Autowired
	private JwtTokenUtil jwtToken;

	
	@PostMapping("/add")
	public Task addTask(@RequestBody Task t, @RequestHeader("token") String token) {
		return service.addTask(t,token);
	}
	
	//Retrieve all Task
	@GetMapping("/get")
	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> listTask=service.getAllTask();
		return new ResponseEntity<List<Task>>(listTask,HttpStatus.OK);
	}
	
	//get TaskItems by assignId
    @GetMapping("/getByAssignId")
    public List<Task> getTasksByAssignId(@RequestParam("id") long assignId) {
           return service.getTasksByAssignId(assignId);
       }
}
