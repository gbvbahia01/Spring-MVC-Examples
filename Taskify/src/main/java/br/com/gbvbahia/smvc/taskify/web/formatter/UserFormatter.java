package br.com.gbvbahia.smvc.taskify.web.formatter;

import br.com.gbvbahia.smvc.taskify.domain.User;
import br.com.gbvbahia.smvc.taskify.service.UserService;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


@Component("UserFormatter")
public class UserFormatter implements Formatter<User> {

	@Autowired
	private UserService userService;
	
	@Override
	public String print(User user, Locale locale) {
		return user.getUserName();
	}

	@Override
	public User parse(String strId, Locale locale) throws ParseException {
		if("-1".equals(strId)) return new User();
		return userService.findById(new Long(strId));
	}

}
