package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements  UserServices{
	
	@Autowired
	UserRepository repo;
	

	@Override
	public String addUser(User user) {
		repo.save(user);
		return "User successfully added";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
		     return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		User user=repo.findByEmail(email);
		if(user==null) {
			return false;
		}
		if(user.getPassword().equals(password)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String getRole(String email) {
		User user=repo.findByEmail(email);
		String role=user.getRole();
		return role;
	}

	@Override
	public User getUser(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		repo.save(user);
		
	}

}
