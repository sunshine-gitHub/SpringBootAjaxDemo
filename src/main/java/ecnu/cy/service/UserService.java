package ecnu.cy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecnu.cy.entity.User;
import ecnu.cy.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}

	public User saveUser(User user) {
		User result = userRepository.save(user);
		
		return result;
	}

	public int deleteById(int id) {
		
		return userRepository.deleteById(id);
	}

	public User updateAge(String age, int id) {
		User result = null;
		int returnResult = userRepository.updateUserAge(age, id);
		if (returnResult > 0 ) {
			result= userRepository.findById(id);
		}
		return result;
	}
}
