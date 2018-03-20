package sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {



	
	
	SQLiteTest comptest = new SQLiteTest();
	try {
		comptest.displayComponents();
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println("Keine DB");
		e.printStackTrace();
	}
	
	
	
	
	}
	
}