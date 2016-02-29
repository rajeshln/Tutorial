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
		CircleDaoSupport daoSupport = context.getBean("circleDaoSupport",CircleDaoSupport.class);
		
		/*Circle circle = dao.getCircle(1);
		if(circle!=null)
		System.out.println(" circle id "+circle.getId()+ "  name is "+circle.getName());
		else 
			System.out.println("No data found ");*/
		
		
	// Calling method using JdbcTemplate
		
		//System.out.println(" Query executed using jdbcTemplate the number of records are"+dao.getRecordCount());
		
		//System.out.println("getting the name from DB using String name = jdbcTemplate.queryForObject(sql, String.class) == "+dao.getCircleName(2));
		
		//System.out.println(" using the arguments "+dao.getCircleNameWithIdArg(1));
		
		// using row mapper
		
		//System.out.println(" using the row mapper  "+dao.getCircleViaRowMapper(1).get(0).getName());
		
		
		// using DaoSupport classes
		System.out.println(" using the row mapper  "+ daoSupport.getCricleCount());
		
		
		
	}

}
