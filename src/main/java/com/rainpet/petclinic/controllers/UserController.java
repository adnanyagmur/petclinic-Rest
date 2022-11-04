package com.rainpet.petclinic.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rainpet.petclinic.entities.User;
import com.rainpet.petclinic.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	private UserService userService;
	
	//Servisimizi Constracter injection ile inject ediyoruz. Bu işlem spring boot ile user repository sinin bean ini bulup inject ediyor.
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	//Tüm user ları getirmek için kullanıyoruz
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//User kaydetmek için kullanıyoruz
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	//User ın id sine göre get işlemi yapıyoruz.
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable Long userId) {
		//Burda orElse amacı böyle bir userId ye sahib bir userımız yoksa null dön demek istoruz
		return userService.getOneUserById(userId);
	}
	
	// id ye göre güncelleme yaparken kullandığımız end point
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser) {
		return userService.updateOneUser(userId,newUser);
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userService.deleteById(userId);
	}
}
