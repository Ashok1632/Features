package com.yash.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.binding.ActivateAccount;
import com.yash.binding.Login;
import com.yash.binding.User;
import com.yash.service.UserMgmtService;

@RestController
public class UserRestControllar {
	@Autowired
	private UserMgmtService service;

	@PostMapping("/user")
	public ResponseEntity<String> userReg(@RequestBody User user) {
		boolean saveUser = service.saveUser(user);
		if (saveUser) {
			return new ResponseEntity<>("Registration Success", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Registration Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/activate")
	public ResponseEntity<String> activateAccount(@RequestBody ActivateAccount acc) {
		boolean activateUserAcc = service.activateUserAcc(acc);
		if (activateUserAcc) {
			return new ResponseEntity<>("Account activated", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Invalid Temporary Password", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = service.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
		User user = service.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		boolean isDeleted = service.deleteUserById(userId);
		if (isDeleted) {
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/status/{userId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer userId, @PathVariable String status) {
		boolean isChanged = service.changeAccountStatus(userId, status);
		if (isChanged) {
			return new ResponseEntity<>("Status Changed", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed To Changed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody Login login)
	{
		String status = service.login(login);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	@GetMapping("forgotpwd/{email}")
	public ResponseEntity<String> forgotPwd(@PathVariable String email)
	{
		String status = service.forgotPwd(email);
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}

}
