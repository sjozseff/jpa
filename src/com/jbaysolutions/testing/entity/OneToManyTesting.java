package com.jbaysolutions.testing.entity;


import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OneToManyTesting {
	private static EntityManager em = null;

    @BeforeClass
    public static void setUpClass() throws Exception {
        if (em == null) {
            em = (EntityManager) Persistence.createEntityManagerFactory("people").createEntityManager();
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    //@Test
    public void testCreateCompany(){
        // Start a transaction
        em.getTransaction().begin();
        // ------------
        
        CompanyEntity c = new CompanyEntity();
        c.setName("JBay Solutions");
        c.setAddress("Av. 5 October, Lisbon");
        
        em.persist(c);
        em.flush();

        em.remove(c);
        // ------------
        // Commit the Transaction
        em.getTransaction().commit();
    }

    //@Test
    public void testCreateCompanyWithEmployee(){
        // Start a transaction
        em.getTransaction().begin();
        // ------------

        CompanyEntity c = new CompanyEntity();
        c.setName("JBay Solutions");
        c.setAddress("Av. 5 October, Lisbon");

        EmployeeEntity e1 = new EmployeeEntity();
        e1.setName("Rui Pereira");
        e1.setPhone("23456789");
        e1.setCompany(c);

        Vector a = new Vector();
        a.add(e1);
        c.setEmployeeCollection(a);

        em.persist(c);
        em.flush();

        em.remove(c);
        // ------------
        // Commit the Transaction
        em.getTransaction().commit();

    }

    @Test
    public void test2(){
        // Start a transaction
        em.getTransaction().begin();
        // ------------
        
        CompanyEntity c = new CompanyEntity();
        c.setName("JBay Solutions");
        c.setAddress("Av. 5 October, Lisbon");

        EmployeeEntity e1 = new EmployeeEntity();
        e1.setName("Rui Pereira");
        e1.setPhone("23456789");
        e1.setCompany(c);

        Vector a = new Vector();
        a.add(e1);
        //c.setEmployeeCollection(a);

        try {
        em.persist(e1);
        em.flush();
        em.refresh(c);
        } catch(Exception e) {
        	e.printStackTrace();
        }
        em.remove(c);
        // ------------
        // Commit the Transaction
        em.getTransaction().commit();
    }
}
