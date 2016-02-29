package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.model.Circle;

@Component
public class JdbcDaoImpl {
	
	
	private DataSource datasource;
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public DataSource getDatasource() {
		return datasource;
	}
	
	
	//setting the datsource in JdbcTemplate while it is getting initialized 
	@Autowired
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	
	int getRecordCount(){
		
	int count = 0;
	String sql = "select count(*) from circle"	;
	
	count= jdbcTemplate.queryForInt(sql);
	
	return count;
		
	}
	
	
	
	
	String getCircleName(int id){
		
		String sql = "select name from circle where id = "+id;
		int args[]= new int[id];
		String name = jdbcTemplate.queryForObject(sql, String.class);
		
		//String name = jdbcTemplate.query(sql, args, rowMapper);
		
		return name;
	}
	
	String getCircleNameWithIdArg(int id){
		
		String sql = "select name from circle where id = ";
		//int args[]= new int[id];
		//String name = jdbcTemplate.query(sql, String.class);
		
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
		
		
	}
	
	
	
	List<Circle> getCircleViaRowMapper(int id){
		
		String sql = "select * from circle where id = "+id;
		List<Circle> circle =	jdbcTemplate.query(sql, new CircleMapper());
		//Circle circle = jdbcTemplate.query(sql, CircleMapper.class);
		return circle;
	}
	
	
	private class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException{
			Circle circle = new Circle(rs.getInt("id"),rs.getString("name"));
			return circle ;
		}
		
		
		
	}
	
	// not using below method for this example , old way of doing the things.
	
	/*Circle getCircle(int circleId){
		
	
		Connection con = null;
		String driver = "org.apache.derby.jdbc.ClientDriver"; 
		
			
		try {
				Class.forName(driver).newInstance();
				con=DriverManager.getConnection("jdbc:derby://localhost:1527/MyDbTest");
			
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
	
	}*/
}