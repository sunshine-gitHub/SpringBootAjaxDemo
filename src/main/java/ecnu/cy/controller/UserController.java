package ecnu.cy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecnu.cy.entity.User;
import ecnu.cy.service.UserService;

@RequestMapping("/api")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/getUserById/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable("id") int id){
		User user = userService.getUserById(id);
		return user;
	}
	
	@GetMapping(value="/getUserByName/{name}")
	public User getUserByName(@PathVariable("name") String name){
		User user = userService.getUserByName(name);
		return user;
	}
	
	@PostMapping(value="/saveUser")
	public User insertUser(@RequestBody User user){
		User result = userService.saveUser(user);
		return result;
	}
	@PutMapping(value="/updateUser/{id}")
	public User insertUser(@PathVariable("id") int id, @RequestParam(value = "age", required=true) String age){
		User result = userService.updateAge(age,id);
		return result;
	}
	@DeleteMapping(value="/delete/{id}")
	public int deleteById(@PathVariable("id") int id){
		int result = userService.deleteById(id);
		return result;
	}
}
