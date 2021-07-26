package eCommerceDemo.dataAccess.conretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> customers = new ArrayList<User>();

	@Override
	public void add(User user) {
		customers.add(user);
		System.out.println("Hibernate ile eklendi." + user.getFirstName() + " " + user.getLastName());

	}

	@Override
	public boolean mailCheck(String mail) {
		for (User i : customers) {
			if (i.getMail() == mail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean pwCheck(String password) {
		for (User i : customers) {
			if (i.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> getAll() {
		for (int i = 0; i < customers.size(); i++) {
			System.out.println(customers.get(i));
		}
		return customers;
	}

}
