package eCommerceDemo.dataAccess.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserDao {

	void add(User user);

	boolean mailCheck(String mail);

	boolean pwCheck(String password);

	List<User> getAll();

}
