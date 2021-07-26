package eCommerceDemo.business.abstracts;

//import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserService {

	void signUp(User user);

	void signIn(User user, String mail, String password);

	void userVerify(User user);

}
