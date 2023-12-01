package dependency;

public class SmsBasedNotificationService implements CustomberNotificationService {
	
	public SmsBasedNotificationService() {
		System.out.println("in cstor of "+getClass().getName());
	}

	@Override
	public void alertNotification(String msg) {
		
		System.out.println(msg + " alert by "+ getClass().getName());
	}

	

}
