package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Circle;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource datasource;
	
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
	Circle getCircle(int circleId){
		
	
		Connection con = null;
		String driver = "org.apache.derby.jdbc.ClientDriver"; 
		
			
		try {
			/*	Class.forName(driver).newInstance();
				con=DriverManager.getConnection("jdbc:derby://localhost:1527/MyDbTest");
			*/
			// using datasource with configuring in xml org.springframework.jdbc.datasource.DriverManagerDatasource
			
				con = datasource.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from circle where id = ?");
				
				Circle circle = null;
				
				ps.setInt(1,circleId);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				{
				circle = new Circle(circleId,rs.getString("name"));
				}
				rs.close();
				ps.close();
				
				return circle;
			
		}
		
		catch (Exception e){
			throw new RuntimeException(e);
		}
	
	}
}