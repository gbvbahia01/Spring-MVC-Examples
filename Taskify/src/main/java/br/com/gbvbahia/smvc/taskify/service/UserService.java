package br.com.gbvbahia.smvc.taskify.service;

import br.com.gbvbahia.smvc.taskify.domain.User;


public interface UserService {
	User findById(int userId);
	User findByUserName(String userName);
	User createNewUser(String name, String userName, String password);
}
