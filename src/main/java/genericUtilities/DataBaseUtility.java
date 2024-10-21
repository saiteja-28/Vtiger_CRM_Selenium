package genericUtilities;
/**
 * This class contains reusable methods to read or write to database
 * @author sai teja
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * this method initiaizes database connection
 * @param jdbcUrl
 * @param Username
 * @param password
 */
public class DataBaseUtility {
	Connection connection;
	Statement statement;
	
	public void databaseInit(String jdbcUrl, String Username, String password) {
		try {
			connection = DriverManager.getConnection(jdbcUrl, Username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement = connection.createStatement();
		}catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	/**
	 * this method reads data from the database
	 * @param query
	 * @param columnName
	 * @return List<Object>
	 */
	public List<Object> readFromDatabase(String query, String columnName){
		ResultSet result = null;
		List<Object> list = new ArrayList<Object>();
		try {
			result = statement.executeQuery(query);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(result.next()) {
				list.add(result.getObject(columnName));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;	
	}
	
	/**
	 * this method modifies the database
	 * @param query
	 * @return int
	 */
	public int modifyDatabase(String query) {
		int result = 0 ;
				try {
					result = statement.executeUpdate(query);
				}catch (SQLException e) {
					e.printStackTrace();
				}
		return result;
	}
	
	/**
	 * this method closes database connection
	 */
	public void closedatabase() {
	   try {
		   connection.close();
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }  
   }
}