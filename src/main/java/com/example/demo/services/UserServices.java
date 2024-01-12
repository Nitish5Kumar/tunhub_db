package com.example.demo.services;

import com.example.demo.entity.User;

public interface UserServices {
	
	public String addUser(User user);
	public boolean emailExists(String email);
	public boolean validateUser(String email, String password);
	public String getRole(String email);
	public User getUser(String email);
	public void updateUser(User user);
}
