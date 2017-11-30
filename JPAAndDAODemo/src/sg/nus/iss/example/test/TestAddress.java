package sg.nus.iss.example.test;

import javax.persistence.EntityManager;

import sg.nus.iss.example.model.Address;

public class TestAddress {

	public static void main(String[] args) {
		Address a1= new Address();
		a1.setCity("Singapore");
		a1.setState("Clementi");
		a1.setStreet("25 Heng mui keng terrace");
		a1.setZip("119615");
		EntityManager entityManager = JPAUtility.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(a1);
		entityManager.getTransaction().commit();

	}

}
