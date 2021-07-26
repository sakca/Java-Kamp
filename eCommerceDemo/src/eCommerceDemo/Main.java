package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserCheckManager;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.abstracts.GoogleService;
import eCommerceDemo.core.concretes.GoogleManagerAdapter;
import eCommerceDemo.core.concretes.MailManager;
import eCommerceDemo.core.concretes.RegexManager;
import eCommerceDemo.dataAccess.conretes.AbcUserDao;
import eCommerceDemo.dataAccess.conretes.HibernateUserDao;
import eCommerceDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "Ayse", "Demir", "ademir@gmail.com", "Ayse123");
		User user2 = new User(2, "Sare", "Akcay", "sreakcy", "Sr123Sr");
		User user3 = new User(3, "Efe", "Tala", "efet@hotmail.com", "efeEfe");
		User user4 = new User(4, "Asli", "Su", "aslisu@hotmail.com", "12Asli12");

		UserService userService1 = new UserManager(new AbcUserDao(), new UserCheckManager(new RegexManager()),
				new MailManager());
		UserService userService2 = new UserManager(new HibernateUserDao(), new UserCheckManager(new RegexManager()),
				new MailManager());
		GoogleService googleService = new GoogleManagerAdapter();

		System.out.println(" 1. islem sonucu:");
		userService1.signUp(user1);
		googleService.googleLogin(" Baþarili. ", user1.getFirstName());
		userService1.signUp(user2);
		userService2.signUp(user3);
		userService2.signUp(user4);

		System.out.println("\n 2. islem sonucu:");
		userService1.signIn(user1, user1.getMail(), user1.getPassword());
		userService2.signIn(user3, user3.getMail(), user3.getPassword());
		userService2.signIn(user4, user4.getMail(), "asliSu123");

		

	}

}
