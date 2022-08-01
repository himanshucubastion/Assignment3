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

import com.assign3.Assignment3.entity.Assignment;
import com.assign3.Assignment3.entity.User;
import com.assign3.Assignment3.security.JwtTokenUtil;
import com.assign3.Assignment3.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private JwtTokenUtil jwtToken;
	
	
	 @PostMapping("/signIn")
	    public Map<String, String> signIn(@RequestBody User user) {
	        User u2 = service.findAuthByUsernameAndPassword(user);

	        Map<String, Object> map = new HashMap<>();
	        map.put("user_id", u2.getId());
	        map.put("username", u2.getUsername());
	        map.put("email", u2.getEmail());
	        map.put("first_name",u2.getFirstname());
	        map.put("last_name", u2.getLastname());
	        String token = jwtToken.generateToken(map);
	        map.clear();
	        Map<String, String> map1 = new HashMap<>();
	        map1.put("accessToken", token);
	        return map1;

	    }

	
	@PostMapping("/signUp")
	public ResponseEntity<User> createUser(@RequestBody User u) {
		User save=service.createUser(u);
		
		return new ResponseEntity<User>(save,HttpStatus.CREATED);
	}
	
	//Retrieve all users
	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listUser=service.getAllUser();
		return new ResponseEntity<List<User>>(listUser,HttpStatus.OK);
	}
	
	//get user by Id
//    @GetMapping("/Id")
//    public List<User> getUserById(@RequestParam("id") long id) {
//           return service.getUserById(id);
//       }
	
//	//Retrieve by an user by id
//		@GetMapping("/get/{id}")
//		public ResponseEntity<?> GetUserById(@PathVariable long id) {
//			User u=service.GetUserById(id);
//			return new ResponseEntity<User>(u,HttpStatus.OK);
//		}
		
		//Delete an user by Id
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Void> DelById(@PathVariable long id){
			service.DelById(id);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

		}
		
		//update user detail
//		@PutMapping("/update/{id}")
//		public ResponseEntity<Auth> updateAuth(@PathVariable long id, @RequestBody Auth auth) {
	//
//			return new ResponseEntity<Auth>(service.updateAuth(auth,id), HttpStatus.OK);
//		}
		
		   @PutMapping("/update")
		    public User updateUser(@RequestBody User user,@RequestHeader("token") String token) {
		        return service.updateUser(user,token);
		    }
		
		
//		@PutMapping("/update")
//		public ResponseEntity<Auth> updateAuth(@RequestBody Auth auth){
//			Auth create=service.updateAuth(auth);
//			return new ResponseEntity<Auth>(create,HttpStatus.OK);
//		}

}
