package edu.northeastern.cs5200.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.northeastern.cs5200.models.Student;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.StudentRepository;
import edu.northeastern.cs5200.repositories.UserRepository;
@Service
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers(){
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}
	public void deleteUserById(int id){
		userRepository.deleteById(id);
	}	

}
