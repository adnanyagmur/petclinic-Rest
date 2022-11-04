package com.rainpet.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rainpet.petclinic.entities.User;
import com.rainpet.petclinic.repos.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	//Repositorymizi Constracter injection ile inject ediyoruz. Bu işlem spring boot ile user repository sinin bean ini bulup inject ediyor.
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}
	public User getOneUserById(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	public User updateOneUser(Long userId,User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}else
		return null;
	}
	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
		
	}

	
	

}
