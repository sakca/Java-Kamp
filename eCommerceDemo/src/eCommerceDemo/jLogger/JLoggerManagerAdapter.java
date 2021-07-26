package eCommerceDemo.jLogger;

import eCommerceDemo.core.abstracts.LoggerService;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String message) {
		JLoggerManager manager = new JLoggerManager();
		manager.log(message);

	}

}
