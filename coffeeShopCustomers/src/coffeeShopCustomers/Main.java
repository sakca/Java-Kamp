package coffeeShopCustomers;

public class Main {

	public static void main(String[] args) {

		BaseCustomerManager custManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		custManager.save(new Customer(1,"Sare","Ak�ay",1999,"0001111000"));

	}

}
