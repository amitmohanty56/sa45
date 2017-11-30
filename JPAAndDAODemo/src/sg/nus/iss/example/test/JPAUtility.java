package sg.nus.iss.example.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtility {
	private static final EntityManagerFactory emFactory;
	static {
		emFactory = Persistence.createEntityManagerFactory("sg.nus.iss.example");
	}

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

	public static void close() {
		emFactory.close();
	}
}
