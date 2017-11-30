package sg.nus.iss.example.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sg.nus.iss.example.model.Staff;

public class TestStaff {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();
		entityManager.getTransaction().begin();
		Staff s1 = new Staff(1, "Suria", "The Stupid");
		entityManager.persist(s1);
		Staff s2 = new Staff(2, "Nancy", "The Naggy");
		entityManager.persist(s2);
		entityManager.getTransaction().commit();

		// Print All
		Query query = entityManager.createQuery("from Staff");
		for (Iterator<Staff> iterator = query.getResultList().iterator(); iterator.hasNext();) {
			Staff s = (Staff) iterator.next();
			System.out.println(s.toString());
		}
		JPAUtility.close();
		System.out.println("Done");

	}

}
