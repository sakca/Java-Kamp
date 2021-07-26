package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.MailService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private UserCheckService userCheckService;
	private MailService mailService;

	public boolean result = false;

	public UserManager(UserDao userDao, UserCheckService userCheckService, MailService mailService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.mailService = mailService;
	}

	@Override
	public void signUp(User user) {
		if (userCheckService.checkEmailValidation(user) == true && userCheckService.checkUserName(user) == true
				&& userCheckService.checkPassword(user) == true) {

			if (userDao.mailCheck(user.getMail()) == false) {
				mailService.sendVerifivationMail(user);
				result = true;
			}

			else {
				System.out.println("Bu mail adresi ile kullanici mevcut.");
				result = false;
			}

		} else {
			result = false;
		}

	}

	@Override
	public void signIn(User user,String mail, String password) {
		userDao.add(user);
		if (userDao.mailCheck(mail) == false) {
			System.out.println("Mail yanlis girildi.");
			result = false;
		} else if (userDao.pwCheck(password) == false) {
			System.out.println("Sifre yanlis girildi.");
			result = false;
		}

		else {
			System.out.println("Giris basarili.");
			result = true;
		}

	}

	@Override
	public void userVerify(User user) {
		if (result == true) {
			userDao.add(user);
			System.out.println("Kullanici sisteme eklendi.");

		} else {
			System.out.println("Sistemde boyle bir kullanici bulunmamakta.");

		}

	}

}
