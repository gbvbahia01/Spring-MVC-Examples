package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.User;


public interface UserDAO {
	
	void createUser(User user);
	User findById(int userId);
	User findByUserName(String userName);

}
