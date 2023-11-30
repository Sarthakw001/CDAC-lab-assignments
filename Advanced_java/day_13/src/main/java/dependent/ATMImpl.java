package dependent;

import dependency.CustomberNotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private CustomberNotificationService alert;
	//private double cash;
	
	private ATMImpl ( CustomberNotificationService a1) {
		this.alert = a1;
		System.out.println("in cnstr of " + getClass().getName() + " " + alert);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		alert.alertNotification(amt+"deposited");
	}

	public CustomberNotificationService getAlert() {
		return alert;
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		alert.alertNotification(amt+"withdraw");
		
	}

	//custom init method
	public void myInit() {
		System.out.println("in init " + alert);// not null
	}

	//custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + alert );
	}

}
