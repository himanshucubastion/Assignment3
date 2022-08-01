package com.assign3.Assignment3.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign3.Assignment3.entity.Assignment;
import com.assign3.Assignment3.entity.User;
import com.assign3.Assignment3.exception.BusinessException;
import com.assign3.Assignment3.repository.UserRepo;
import com.assign3.Assignment3.security.JwtTokenUtil;


@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	//validating existing user during login
    public User findAuthByUsernameAndPassword(User user) {
        User u = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return u;
//        if(list.size() == 1) return list.get(0);
       // return null;
    }
	
	
	
	//Adding new user
	public User createUser(User user) {
//		// this is a validation part with "if", it should never be in the try block
//		if (auth.getid() <= 0) {
//			throw new EmptyInputException();
//		}
//		Optional<Auth> user1 = repo.findById(auth.getid());
//		if (user1.isPresent())
		//	throw new DuplicateEntry();
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("userId", auth.getUsername());
		
		

	  return repo.save(user);
		//return jwtutils.generateToken(map);
	}

	//get all users
	public List<User> getAllUser() {
		List<User> userList = null;
		try {
			userList = repo.findAll();
		} catch (Exception e) {
			throw new BusinessException("605",
					"Something went wrong in Service layer" + "while fetching all employees" + e.getMessage());
		}
		if (userList.isEmpty())
			throw new BusinessException("604", "List is completely empty");
		return userList;
	}


//	//get user by id
//	public User GetUserById(long id) {
//		if(repo.findById(id).get()==null) {
//			throw new NoSuchElementException();
//		}
//		return repo.findById(id).get();
//	}

	//delete user by id
	public void DelById(long id) {
		
		if(repo.findById(id).get()==null) {
			throw new NoSuchElementException();
		}
		repo.deleteById(id);
	}	

	
	//update user details
//	public Auth updateAuth(Auth auth, long id) {
//		//checking if the address id exists or not
//		Auth existAuth=repo.getById(id);
//		if (existAuth == null) {
//			throw new NoSuchElementException();
//		}
//		
//		existAuth.setPassword(auth.getPassword());
//		existAuth.setUsername(auth.getUsername());
//		existAuth.setUser(auth.getUser());
//		
//		return repo.save(existAuth);	
//	}

	public User updateUser(User user, String token) {
        int userId =(Integer) jwtTokenUtil.getAllClaimsFromToken(token).get("user_id");
    User u = repo.findById(Long.parseLong(""+userId)).orElse(null);

    u.setUsername(u.getUsername());

    return  repo.save(u);
	}




}

