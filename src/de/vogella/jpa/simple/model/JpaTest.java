package de.vogella.jpa.simple.model;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class JpaTest {
	private static final String PERSISTENCE_UNIT_NAME = "people";
	private EntityManagerFactory factory;

	//@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		Family family = new Family();
		family.setDescription("Family for the Knopfs");
		em.getTransaction().begin();
		em.persist(family);
		
		for (int i = 0; i < 40; i++) {
			Person person = new Person();
			person.setFirstName("Jim_" + i);
			person.setLastName("Knopf_" + i);
			em.persist(person);
			// now persists the family person relationship
			family.getMembers().add(person);
		
			em.persist(family);

		}

		// Commit the transaction, which will cause the entity to
		// be stored in the database
		em.getTransaction().commit();

		// It is always good practice to close the EntityManager so that
		// resources are conserved.
		em.close();

	}

	// @Test
	public void checkAvailablePeople() {

		// now lets check the database and see if the created entries are there
		// create a fresh, new EntityManager
		EntityManager em = factory.createEntityManager();

		// Perform a simple query for all the Message entities
		Query q = em.createQuery("select m from Person m");

		// We should have 40 Persons in the database
		assertTrue(q.getResultList().size() == 40);

		em.close();
	}

	@Test
	public void checkFamily() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Query q = em.createQuery("select f from Family f");

		Family family = em.find(Family.class, 201);
		try {
		family.setDescription("Family for the Knopfs!!!");
		family.getMembers().get(0).setFirstName("Robiii");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		em.getTransaction().commit();
		em.close();
	}

	// @Test(expected = javax.persistence.NoResultException.class)
	public void deletePerson() {
		EntityManager em = factory.createEntityManager();
		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName");
		q.setParameter("firstName", "Jim_1");
		q.setParameter("lastName", "Knopf_!");
		Person user = (Person) q.getSingleResult();
		// em.remove(user);
		em.getTransaction().commit();
		Person person = (Person) q.getSingleResult();
		// Begin a new local transaction so that we can persist a new entity

		em.close();
	}
}
