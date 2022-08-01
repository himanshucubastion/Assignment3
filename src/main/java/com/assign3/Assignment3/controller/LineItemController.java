package com.assign3.Assignment3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assign3.Assignment3.entity.LineItem;
import com.assign3.Assignment3.security.JwtTokenUtil;
import com.assign3.Assignment3.service.LineItemService;

@RestController
@RequestMapping("/line-item")
public class LineItemController {
	
	@Autowired
	private LineItemService service;
	
	@Autowired
	private JwtTokenUtil jwtToken;

	
//	@PostMapping("/add")
//	public LineItem addLineItem(@RequestBody LineItem l, @RequestHeader("token") String token) {
//		return service.addLineItem(l,token);
//	}
	@PostMapping("/add")
	public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem l, @RequestHeader("token") String token) {
		return new ResponseEntity<LineItem>(service.addLineItem(l,token), HttpStatus.CREATED);
	}
	
	//Retrieve all Line Items
	@GetMapping("/get")
	public ResponseEntity<List<LineItem>> getAllLineItem() {
		List<LineItem> listLineItem=service.getAllLineItem();
		return new ResponseEntity<List<LineItem>>(listLineItem,HttpStatus.OK);
	}
	
	//get lineItems by taskId
    @GetMapping("/getByTaskId")
    public ResponseEntity<List<LineItem>> getLineItemsByTaskId(@RequestParam("id") long taskId) {
           return new ResponseEntity<List<LineItem>>(service.getLineItemsByTaskId(taskId),HttpStatus.OK) ;
       }
    
	//Delete a lineItem by Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> DelById(@PathVariable long id){
		service.DelById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	//Updating lineItem
//	@PatchMapping("/update")
//	public ResponseEntity<LineItem> updateLineItem(@RequestBody LineItem lineItem){
//		//Auth create=service.updateAuth(auth);
//		return new ResponseEntity<LineItem>(service.updateLineItem,HttpStatus.OK);
//	}
}
