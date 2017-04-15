import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

	ResultSet rs = null;
	
	
	public static String connect(){
		String a = "";
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return null;
		}
		
		System.out.println("Oracle JDBC Driver Registered!");
		
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@jasmine.cs.vcu.edu:20037/xe", "hobsonal2", "V00390396");
			Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from Employees");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            while (rs.next()) {
            	//Print one row          
            	for(int i = 1 ; i <= columnsNumber; i++){

            	      a += rs.getString(i) + " | "; //Print one element of a row

            	}

            	  a += "\n";//Move to the next line to print the next row.           

            	    }
		}
		catch(SQLException e){
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		
		if (connection != null) {
			
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
		
		System.out.println(a);
		return a;
		
		
	}
}
