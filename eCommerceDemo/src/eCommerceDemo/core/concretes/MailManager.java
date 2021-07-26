package eCommerceDemo.core.concretes;

import eCommerceDemo.core.abstracts.MailService;
import eCommerceDemo.entities.concretes.User;

public class MailManager implements MailService {

	@Override
	public void sendVerifivationMail(User user) {
		System.out.println("Dogrulama epostasi " + user.getMail() + " adresine gonderildi. ");

	}

}
