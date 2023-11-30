package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		// launch SC
		try (ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running ....");
			ATMImpl ref1=ctx.getBean("my_atm", ATMImpl.class);
			ref1.deposit(50000);
			ATMImpl ref2=ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(ref1==ref2);
		
		} 
	
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
