package com.ty.test;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Branch;
import com.ty.dto.Hospital;



public class TestSaveHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Hospital hospital = new Hospital() ;
		hospital.setName("appolo");
		hospital.setWebsite("appolo.com");
		
		Branch branch = new Branch() ;
		branch.setName("kolkata");
		branch.setState("westbengal");
		branch.setCountry("india");
		branch.setPhoen(8888800000l);
		branch.setHospital(hospital);
		
		Branch branch1 = new Branch() ;
		branch1.setName("banglore");
		branch1.setState("karnataka");
		branch1.setCountry("india");
		branch1.setPhoen(9999900000l);
		branch1.setHospital(hospital);
		
		Branch branch2 = new Branch() ;
		branch2.setName("vskp");
		branch2.setState("andhrapradesh");
		branch2.setCountry("india");
		branch2.setPhoen(7777700000l);
		branch2.setHospital(hospital);
		
//		List<Branch> branches = new ArrayList<Branch>() ;
//		branches.add(branch) ;
//		branches.add(branch1) ;
//		branches.add(branch2) ;
//		
//		hospital.setBranches(branches);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityTransaction.commit();
		
	}
}
