package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {

	
	private static Connection con;
	private static boolean hasData = false;
	
	
	public ResultSet displayComponents() throws ClassNotFoundException, SQLException {
		
		if(con == null) {
			getConnection();
		}
		
		Statement state = con.createStatement();
		System.out.println("HIER KOMMT DER USER");
		ResultSet res = state.executeQuery("SELECT compType FROM components");
		
		return res;
	}


		
	
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:Components.db");
		initialise();
	}



	
	private void initialise() throws SQLException {
		// TODO Auto-generated method stub
		if(hasData == false) {
			
			hasData = true;
			
			Statement state = con.createStatement();
			try{
				ResultSet res = state.executeQuery("SELECT compType FROM components");
				if(res.next()) {
					System.out.println("Tabelle schon vorhanden");
					return;
				}
			}
			catch (Exception e) {
				System.out.println("ICH BIN DIE EXCEPTION");
			}
			
				System.out.println("Keine Componenten Tabelle gefunden, erstelle neue Tabelle");
				Statement state2 = con.createStatement();
				state2.execute("CREATE TABLE components(id integer," + "compNumber integer,"
						+ "compType varchar(60)," + "compFunction varchar(60),"
						+ "primary key(id));");
				System.out.println("Tabel erstellt");
				
//				inserting some data
				System.out.println("Inserting Dummy Data");
				PreparedStatement prep = con.prepareStatement("INSERT INTO components values(?,?,?,?);");
				prep.setInt(2, 1);
				prep.setString(3, "Optokoppler");
				prep.setString(4, "Unterbrechung Sender");
				prep.execute();
				
						
				PreparedStatement prep2 = con.prepareStatement("INSERT INTO components values(?,?,?,?);");
				prep2.setInt(2, 2);
				prep2.setString(3, "Treiber");
				prep2.setString(4, "Unterbrechung Eingang");
				prep2.execute();
				
				System.out.println("Keine FailureMode Tabelle gefunden, erstelle neue Tabelle");
				Statement state3 = con.createStatement();
				state3.execute("CREATE TABLE failureMode(id interger,"
						+ "partOf varchar(60)," + "failerModeDesription varchar(500)," +"overAll double," + "measures carchar(500)," + "dc double," + "comment varchar(500)," + "lsD double," + "lSu double," + "lDd double," + "lDu double,"
						+ "primary key(id));");
				System.out.println("FailureMode erstellt");
				
				
				
				System.out.println("Dummies erstellt");
				
			}
		
	}
	
	
	
	public void addComponent(String comptype, String failureMode) throws ClassNotFoundException, SQLException {
		if (con == null) {
			getConnection();
		
		}
		
		PreparedStatement prep = con.prepareStatement("INSTERT INTO user values(?,?,?);");
		prep.setString(2, comptype);
		prep.setString(3, failureMode);
		prep.execute();
				
	}
	
	
	
	
}
