package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import core.Component;
import core.FailureMode;

public class SqlComponentHandler {

	
	private static Connection connection;
	private static boolean hasData = false;
	
	
	
	public ResultSet displayComponents() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			getConnection();
		}
		
		Statement state = connection.createStatement();
		System.out.println("HIER KOMMT DER USER");
		ResultSet resultSet = state.executeQuery("SELECT compType FROM components");
		
		return resultSet;
	}


		
	
	
	private void getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:Components.db");
		initialise();
	}



	
	private void initialise() throws SQLException {
		// TODO Auto-generated method stub
		if(hasData == false) {
			hasData = true;
			Statement statement = connection.createStatement();
			try{
				ResultSet result = statement.executeQuery("SELECT compType FROM components");
				if(result.next()) {
					System.out.println("Tabelle schon vorhanden");
					return;
				}
			}
			catch (Exception e) {
				System.out.println("ICH BIN DIE EXCEPTION");
				}
			
			
			//If no table is found, create table components
			
			
				System.out.println("Keine Componenten Tabelle gefunden, erstelle neue Tabelle");
				Statement createComponentstable = connection.createStatement();
				createComponentstable.execute(
						"CREATE TABLE components"
						+ "(id integer,"
						+ "compNumber integer,"
						+ "compType varchar(90),"
						+"compFunction varchar(90),"
						+"primary key(id));"
						);
				
				System.out.println("components Tabelle erstellt");
				
				
				
			//If no table is found, create table failuremodes
				
				
				Statement createFailuremodestable = connection.createStatement();
				createFailuremodestable.execute(
						"CREATE TABLE failuremodes"
						+ "(id integer,"
						+ "isPartOfComponent varchar(90),"
						+ "failureModeDescription varchar(200)," 
						+ "overALlProportion DOUBLE,"
						+ "measures varchar(200),"
						+ "dc DOUBLE,"
						+ "lambdaSafeDetected DOUBLE,"
						+ "lambdaSafeUndetected DOUBLE,"
						+ "lambdaUnSafeDetected DOUBLE,"
						+ "lambdaUnSafeUndetected DOUBLE,"
						+ "primary key(id));"
						);
				
				System.out.println("components Tabelle erstellt");
				
				
							
			//inserting some standard components into the tables
				
				Component optokoppler = new Component("Optokoppler", 1, "used to transfer signals between two devided circuits");
				optokoppler.addFailureMode("Unterbrechung Sender", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				optokoppler.addFailureMode("Kurzschluss Sender", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				optokoppler.addFailureMode("Unterbrechung Empfänger", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				optokoppler.addFailureMode("Kurzschluss Empfänger", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				optokoppler.addFailureMode("Kurzschluss Eingang, Ausgang", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				optokoppler.addFailureMode("Drift", 0.25, "Fehler wird durch fehlende Dynamik erkannt", 1.00, "", 0.1, 0.0, 0.0, 0.0);
				
				
				
				
				//Adding Component
				
				addComponent(optokoppler);
				
						
			
				
			}
		
	}
	
	
	
	public void addComponent(String comptype, String failureMode) throws ClassNotFoundException, SQLException {
		if (connection == null) {
			getConnection();
		
		}
		
		PreparedStatement prep = connection.prepareStatement("INSTERT INTO user values(?,?,?);");
		prep.setString(2, comptype);
		prep.setString(3, failureMode);
		prep.execute();
				
	}
	
	
	public void addComponent(Component component) throws SQLException {
		
		
		PreparedStatement prepComponentStatement = connection.prepareStatement("INSERT INTO components values(?,?,?,?);");
		prepComponentStatement.setInt(2, component.componentNumber);
		prepComponentStatement.setString(3, component.componentType);
		prepComponentStatement.setString(4, component.componentFunction);
		prepComponentStatement.execute();
		
		for(FailureMode f : component.failuremodeList) {
			
			System.out.println("Adde failuremodes");
			
			PreparedStatement prepFailureModeStatement = connection.prepareStatement("INSERT INTO failuremodes values(?,?,?,?,?,?,?,?,?,?);");
			prepFailureModeStatement.setString(2, component.componentType);
			prepFailureModeStatement.setDouble(4, f.overAllProportion);
			prepFailureModeStatement.setString(5, "measures");
			prepFailureModeStatement.setDouble(6, f.dc);
			prepFailureModeStatement.setDouble(7, f.getLambdaSd());
			prepFailureModeStatement.setDouble(8, f.getLambdaSu());
			prepFailureModeStatement.setDouble(9, f.getLambdaDd());
			prepFailureModeStatement.setDouble(10, f.getLambdaDu());
			
		}
		
		
		
	}
	
}
