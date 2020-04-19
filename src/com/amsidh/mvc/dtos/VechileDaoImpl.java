/**
 * 
 */
package com.amsidh.mvc.dtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author amsidhlokhande
 *
 */
@Component
public class VechileDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTamplate;
	public Vechile getVechileByVechileId(Integer vechileId)
	{
		
		Vechile vechile=null;
		try
		{
			String query="SELECT VECHILETYPE FROM VECHILE WHERE VECHILEID=1";
			jdbcTamplate.execute(query);
			String type=jdbcTamplate.queryForObject(query, String.class);
			
			vechile=new Vechile(vechileId,type);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return vechile;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTamplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTamplate() {
		return jdbcTamplate;
	}

	public void setJdbcTamplate(JdbcTemplate jdbcTamplate) {
		this.jdbcTamplate = jdbcTamplate;
	}
	
	
}
