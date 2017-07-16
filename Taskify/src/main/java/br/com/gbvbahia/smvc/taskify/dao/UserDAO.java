package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.File;
import br.com.gbvbahia.smvc.taskify.domain.User;
import java.util.List;


public interface UserDAO {
	
	void createUser(User user);
	User findById(Long userId);
	User findByUserName(String userName);
	void deleteUser(User user);
	List<User> findAllUsers();

	File addProfileImage(Long userId, String fileName);
	void removeProfileImage(Long userId);
}
