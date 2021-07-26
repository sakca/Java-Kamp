package eCommerceDemo.core.concretes;

import eCommerceDemo.Google.GoogleManager;
import eCommerceDemo.core.abstracts.GoogleService;
import eCommerceDemo.entities.concretes.User;

public class GoogleManagerAdapter implements GoogleService {

	@Override
	public void googleLogin(String message, String name) {

		GoogleManager googleRegister = new GoogleManager();
		googleRegister.register(message, name);

	}
}
