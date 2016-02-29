package com;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Circle;

public class JDBCDemo {
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		
		
		Circle circle = dao.getCircle(1);
		if(circle!=null)
		System.out.println(" circle id "+circle.getId()+ "  name is "+circle.getName());
		else 
			System.out.println("No data found ");
	}

}
