package sg.edu.nus.test;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sg.edu.nus.model.Staff;

public class TestStaffJPA {

	public static void main(String[] args) {
		EntityManager em = JPAUtility.getEntityManager();
		Staff s1 = new Staff(1, "Suria", "Stupid");
		Staff s2 = new Staff(2, "Nancy", "Naggy");
		Staff s3 = new Staff(3, "GGGG", "Goofey");
		em.getTransaction().begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.getTransaction().commit();
		System.out.println("Data in mysql:");
		Query query = em.createQuery("from Staff");
		for (Iterator<Staff> iterator = query.getResultList().iterator(); iterator.hasNext();) {
			Staff s = (Staff) iterator.next();
			System.out.println(s.toString());
			
		}
		em.close();

	}

}
