package org.rajesh.hibernate;

/* one to one relationship example 
 * 1) Need to define new entity Vehicle - provide @ID,@Entity annotation
 * 2) Add the Entity Mapping in cfg.xml
 * 3) In UserDetails create Object of Vehicle and annotate with @OneToOne
 * 4) In test class create UserDetails , Vehicle .. add vehicle to UserDetails and Save objects
 * */


import java.util.HashSet;
import java.util.Set;

// example no 10 saving collection


import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rajesh.dto.UserDetails;
import org.rajesh.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try{
		
			
		session.beginTransaction();
		
		UserDetails details1 = new UserDetails();
		details1.setName("Ojas");
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setV_id(7451);
		vehicle.setV_name("Boxer");
		session.save(vehicle); // Have to separately save the vehicle object and then establish the mapping
		
		details1.setVehicle(vehicle);
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
		
		}
			catch(JDBCException ex){
					ex.getSQLException().getNextException().printStackTrace();
					
		}
		
	}

}
