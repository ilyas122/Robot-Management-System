package cmpe.cloudcomputing.robot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import cmpe.cloudcomputing.robot.entity.User;
import cmpe.cloudcomputing.robot.repository.UserRepository;
import cmpe.cloudcomputing.robot.security.SecurityConfig;

import java.security.SecureRandom;
import java.util.List;

@RestController
public class UserController {
	private UserRepository userRepository;
	public UserController(UserRepository repository) {
		super();
		this.userRepository = repository;
	}

	public User register(User user) {
		//Encrypt user's password using BCrypt
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder(SecurityConfig.bCryptStrength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		return userRepository.save(user);
	}

	public void unregister(Integer uid) {
		//start to delete all information from tables on DB.
		userRepository.deleteById(uid);
	}
	
	//TEST
	@CrossOrigin
    @GetMapping("/api/user/all")
    public List<User> getAllAccount() {
		return userRepository.findAll();
    }
}

/*
import java.util.List;
import cmpe.cloudcomputing.robot.entity.User;
import cmpe.cloudcomputing.robot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired
	UserService userservice;
	
	//Create User then, return UserID
	@PostMapping("/api/user/create")
	public User createUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	@GetMapping("/api/user/login")
	public boolean login(@RequestBody User user) {
		return userservice.login(user);
	}
	
	//TEST
	@CrossOrigin
    @GetMapping("/api/client/all")
    public List<User> getAllAccount() {
		return userservice.findAll();
    }

}*/