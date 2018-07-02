package org.uc.exercise.tvd.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private Connection cn;
	
	public Connector(){
		System.out.println("Starting connection...");
		try { 
			//com.microsoft.sqlserver.jdbc.SQLServerDriver
			//oracle.jdbc.driver.OracleDriver  com.mysql.jdbc.Driver org.sqlite.JDBC
			Class.forName("org.sqlite.JDBC").newInstance(); 
			
		} catch(ClassNotFoundException err){
			err.printStackTrace();
		} catch(InstantiationException err){
			err.printStackTrace();
		} catch(IllegalAccessException err){
			err.printStackTrace();
		}
		System.out.println("try to connect...");
		try { 
			
			
			String connectionUrl = "jdbc:sqlite:../user.db";  
			/*
			 * "jdbc:mysql://db4free.net:3306/uc_tvd_data",
		                                   "osvaldorioz","punt0net"
			 */
		    cn =                            
		       DriverManager.getConnection(connectionUrl);

		    
		}catch (SQLException ex) {
		    cn = null;
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public Connection getConnection(){
		return cn;
	}
}
