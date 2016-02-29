package com;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


public class CircleDaoSupport extends SimpleJdbcDaoSupport {
	
	TransactionTemplate tx = new TransactionTemplate();
	
	
	public int getCricleCount(){
		
		// programmatically adding transactions
		/*tx.execute(new TransactionCallback<Void>() {

			@Override
			public Void doInTransaction(TransactionStatus status) {
				
				try {
					
					throw new RuntimeException();
				} catch (RuntimeException e) {
					// TODO Auto-generated catch block
				status.setRollbackOnly();
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				return null;
			}
			
			
			
		});*/
		String sql = "select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
		//this.getNamedParameterJdbcTemplate().q(sql, );
	}
	


	
	
	
}
