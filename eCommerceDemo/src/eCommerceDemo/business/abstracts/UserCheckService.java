package eCommerceDemo.business.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserCheckService {
	boolean checkUserName(User user);

	boolean checkEmailValidation(User user);

	boolean checkPassword(User user);

}
