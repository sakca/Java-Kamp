package interfaces;

public class Main {

	public static void main(String[] args) {
		Logger[] loggers = { new SmsLogger(), new EmailLogger() };
		CustomerManager customerManager = new CustomerManager(loggers);

		Customer sare = new Customer(1, "Sare", "Akcay");
		customerManager.add(sare);

	}

}
