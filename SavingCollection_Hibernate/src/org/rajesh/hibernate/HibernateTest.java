package org.rajesh.hibernate;

import java.util.HashSet;
import java.util.Set;

// example no 10 saving collection


import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajesh.dto.Address;
import org.rajesh.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try{
		session.beginTransaction();
		
		Set <Address> addresses = new HashSet<Address>();
		
		
		Address addr = new Address();
		
		addr.setCity("Udgir");
		addr.setPincode("413517");
		addr.setState("Maharashtra");
		addr.setStreet("degloor Road");
		
		
		Address addr2 = new Address();
		
		addr2.setCity("Pune");
		addr2.setPincode("411014");
		addr2.setState("Maharashtra");
		addr2.setStreet("Nagar Road");
		
		addresses.add(addr);
		addresses.add(addr2);
		
		UserDetails details1 = new UserDetails();
		
		
		details1.setName("Ojas");
		
		details1.setAddresses(addresses);
	
				
		session.save(details1);
		
		
		
		session.getTransaction().commit();
			session.close();
		}
		
		// adding for knowing the exact cause of JDBCException
		catch (JDBCException jdbce) {
		    jdbce.getSQLException().getNextException().printStackTrace();
		}
		
		
		// code for fetching the data
				// create new session
				Session sessionNew = sessionFactory.openSession();
				try {
					sessionNew.beginTransaction();
					// Need to provide the model object we want to retrieve 
				UserDetails ud =	(UserDetails)sessionNew.get(UserDetails.class, 10);
				System.out.println(" user "+ud.getName());
				
				// test of closing the session and see if we can fetch the address
				//session.close();
				// we can configure to fetch the address eagerly
				System.out.println(" the list of addresses is "+ud.getAddresses().toString());
				
			//	System.out.println("  data from database "+ud.getName());
			}
			catch(JDBCException ex){
					ex.getSQLException().getNextException().printStackTrace();
					
				}
		
//		session.close();
		
		
	}

}
