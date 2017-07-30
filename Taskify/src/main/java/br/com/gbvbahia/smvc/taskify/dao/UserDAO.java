package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long>{
	
	User findByUserName(String userName);
//	void createUser(User user);
//	void createUsers(List<User> users);
//	User findById(Long userId);
//	User findByUserName(String userName);
//	void deleteUser(User user);
//	void updateUser(Long userId, User user);
//	List<User> findAllUsers();
//
//	File addProfileImage(Long userId, String fileName);
//	void removeProfileImage(Long userId);
}
