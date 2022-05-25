package com.ty.test;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Mobile;
import com.ty.dto.Sim;

public class TestSaveMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
	
		
		Sim sim1 = new Sim() ;
		sim1.setProvider("airtel");
		sim1.setType("4g");
		sim1.setImei("artl1234");
		
		Sim sim2 = new Sim() ;
		sim2.setProvider("bsnl");
		sim2.setType("4g");
		sim1.setImei("bsnl5678");
		
		Sim sim3 = new Sim() ;
		sim3.setProvider("vi");
		sim3.setType("4g");
		sim1.setImei("vi9101");
		
		List<Sim> sims1 = new ArrayList<Sim>() ;
		
		sims1.add(sim1) ;
		
		List<Sim> sims2 = new ArrayList<Sim>() ;
		sims2.add(sim2) ;
		sims2.add(sim3) ;
		
		
		
		
		Mobile mobile2 = new Mobile() ;
		mobile2.setName("sony");
		mobile2.setCost(14500);
		mobile2.setSims(sims1);
		
		Mobile mobile3 = new Mobile() ;
		mobile3.setName("mi");
		mobile3.setCost(14500);
		mobile3.setSims(sims2);
		
		sim1.setMobile(mobile2);
		sim2.setMobile(mobile3);
		sim3.setMobile(mobile3);
		
		entityTransaction.begin();
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityManager.persist(sim3);
		entityManager.persist(mobile2);
		entityManager.persist(mobile3);
		entityTransaction.commit();
		
	}
}
