package dependency;

public class EmailBasedNotificationService implements CustomberNotificationService {

	public EmailBasedNotificationService() {
		System.out.println("in cstor of "+getClass().getName());
	}

	@Override
	public void alertNotification(String msg) {
		
		System.out.println(msg + " alert by "+ getClass().getName());
	}

}
