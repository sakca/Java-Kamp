package eCommerceDemo.business.concretes;

import eCommerceDemo.business.abstracts.UserCheckService;
import eCommerceDemo.core.abstracts.RegexService;
import eCommerceDemo.entities.concretes.User;

public class UserCheckManager implements UserCheckService {

	private RegexService regexService;

	public UserCheckManager(RegexService regexService) {
		super();
		this.regexService = regexService;
	}

	@Override
	public boolean checkUserName(User user) {
		if (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) {
			System.out.println("Bu kisim bos birakilamaz.");
			return false;
		} else {
			if (user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
				System.out.println("Ad ve soyad iki harften kucuk olamaz.");
				return false;
			}
			
		}return true;
	}

	@Override
	public boolean checkEmailValidation(User user) {
		if (regexService.checkMail(user.getMail()) == true) {
			return true;
		} else {
			System.out.println("Mail uygun formatta bulunmamakta.");
			return false;
		}
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("Bu kisim bos birakilamaz.");
			return false;
		} else {
			if (user.getPassword().length() < 6) {
				System.out.println("Sifre 6 karakterden kisa olamaz.");
				return false;
			}

		}
		return true;

	}
}
