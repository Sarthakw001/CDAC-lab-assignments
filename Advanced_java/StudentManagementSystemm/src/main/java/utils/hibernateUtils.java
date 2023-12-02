package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {
	private static SessionFactory factory;
	public static SessionFactory getFactory() {
		Configuration cfg = new Configuration();
		cfg.configure();
		factory = cfg.buildSessionFactory();
		return factory;
	}
	
	public static void closeFactory() {
		if(factory.isOpen()) {
			factory.close();
		}
	}
}
