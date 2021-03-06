import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	ResultSet rs = null;
	static Connection globalConnection;
	
	/**
	 * Method to print all the members of the organization.
	 * @return
	 */
	public static String printMembers() {
		String a = "";
		Statement st;
		try {
			st = globalConnection.createStatement();
			ResultSet rs = st.executeQuery("select * from Employees");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				// Print one row
				for (int i = 1; i <= columnsNumber; i++) {

					a += rs.getString(i) + " | "; // Print one element of a row

				}

				a += "\n";// Move to the next line to print the next row.

			}
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/*public static void addMember(){
		Statement st;
		try{
			st = globalConnection.createStatement();
			st.executeUpdate("INSERT INTO Employees (emp_id, emp_name, emp_address, emp_state, emp_position, emp_manager)VALUES (001, \"John Doe\", \"1 River Walk, Green Street\", 3, 5, 1000)");
			
		}catch (Exception e) { 
        System.err.println("Got an exception! "); 
        System.err.println(e.getMessage()); 
    } 
	}*/
	
	/**
	 * Method to connect to the jasmine server
	 */
	public static void connect(){
		String a = "";
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
		}
		
		System.out.println("Oracle JDBC Driver Registered!");
		
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@jasmine.cs.vcu.edu:20037/xe", "hobsonal2", "V00390396");
			globalConnection = connection;
		}
		catch(SQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		if (connection != null) {
			
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

	}
}
