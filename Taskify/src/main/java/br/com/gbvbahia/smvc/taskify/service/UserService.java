package br.com.gbvbahia.smvc.taskify.service;

import br.com.gbvbahia.smvc.taskify.domain.File;
import br.com.gbvbahia.smvc.taskify.domain.User;
import java.util.List;


public interface UserService {
	User findById(Long userId);

	User findByUserName(String userName);

	User createNewUser(User user);

	void updateUser(User user);

	void deleteUser(User user);

	List<User> findAllUsers();

	File addProfileImage(Long userId, String fileName);

	void deleteProfileImage(Long userId);

}
