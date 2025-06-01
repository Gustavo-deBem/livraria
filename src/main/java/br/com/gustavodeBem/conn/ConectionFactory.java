package br.com.gustavodeBem.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	
	public static Connection getConection() {
		
		String url ="jdbc:mysql://localhost:3306/Livraria";
		String user= "root";
		String password = "123321";
		
		try {
			return DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
