package utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.core.ResultCursor;

import BaseClass.Base;

public class dbConnectivity extends Base {

	public Connection connectDB() throws ClassNotFoundException, IOException {	
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		// db connection details
		String dbURL = getProperties().getProperty("dbURL_postgres");
		String url = "jdbc:postgresql://"+dbURL;
		String username = getProperties().getProperty("username");
		String password = getProperties().getProperty("password");

		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Established connection with db...");
		}
		catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
		return con;


	}

	public void executeQuery(Connection con, String query) throws Exception {

		Statement stmt=con.createStatement();
		ResultSet rst=stmt.executeQuery(query);

		while(rst.next()) {
			System.out.println(rst.getInt(1)+", "+rst.getString(2));

		}

		rst.close();
		stmt.close();
		con.close();		
	}

	public static void main(String args[]) throws Exception {

		dbConnectivity db=new dbConnectivity();
		Connection con=null;
		con=db.connectDB();
		String query="SELECT * from company";
		db.executeQuery(con, query);


	}







}

