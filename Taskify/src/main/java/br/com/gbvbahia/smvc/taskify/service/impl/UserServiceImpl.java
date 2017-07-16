package br.com.gbvbahia.smvc.taskify.service.impl;

import br.com.gbvbahia.smvc.taskify.dao.UserDAO;
import br.com.gbvbahia.smvc.taskify.domain.User;
import br.com.gbvbahia.smvc.taskify.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	public UserServiceImpl() {
		logger.debug("SimpleTaskService instantiated");
	}

	public User findById(int userId) {
		return this.userDAO.findById(userId);
	}

	public User findByUserName(String userName) {
		return this.userDAO.findByUserName(userName);
	}

	public User createNewUser(String name, String userName, String password) {
		User newUser = new User(-1, name, userName, password);
		this.userDAO.createUser(newUser);
		logger.debug("New user created successfully: " + newUser);
		return newUser;
	}

}
