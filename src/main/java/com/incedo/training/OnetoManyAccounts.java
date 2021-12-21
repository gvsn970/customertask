package com.incedo.training;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OnetoManyAccounts {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("customerbanking");
			entityManager = emf.createEntityManager();

			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();
			
			//entity
			Customer customer =new Customer();
			customer.setCname("HCL");
			customer.setCnumber("998769");
			
			Account account1 = new Account();
			account1.setAmount(7000);
			account1.setStatus("Okk");
			account1.setCustomer(customer);
			
			//Second call
			Account account2 = new Account();
			account2.setAid(8000);
			account2.setStatus("okkk");
			account2.setCustomer(customer);
			
			List<Account> list=new ArrayList();
			list.add(account1);
			list.add(account2);
			
			
			customer.setListAccounts(list);
			
			// save call
            entityManager.persist(customer);
            
            System.out.println("customer detials successfull....");
            
            }catch (Exception e) {
    			System.out.println(e);
    			//transaction.rollback();
            }finally {
    			if (transaction != null) {
    				transaction.commit();
    			}
    			if (entityManager != null) {
    				entityManager.close();
    			}
    			if (emf != null) {
    				emf.close();
    			}
		
            }
	}
	}
