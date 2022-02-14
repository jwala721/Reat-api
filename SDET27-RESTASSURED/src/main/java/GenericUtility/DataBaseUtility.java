package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	/**
	 * this method establish connection with database
	 * @throws Throwable
	 */
	Connection connect = null;
	public void connectToDb() throws Throwable 
	{
		 Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		connect = DriverManager.getConnection(IConstants.dbURL, IConstants.dbUserName, IConstants.dbPassword);
	}
	
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag = false;
		ResultSet result = connect.createStatement().executeQuery(query);
		while(result.next()) 
		{
			String value = result.getString(columnIndex);
			if(value.equalsIgnoreCase(expData))
			{
			flag = true; //raising flag
			break;
		}
	}
		if(flag)
		{
			System.out.println(expData+"Data Verified");
			return expData;
		}
		else 
		{
			System.out.println("data not present");
			return "";
		}
	}
	
	/**
	 * this method will close the database connection
	 * @throws Throwable
	 */
	public void closeDb() throws Throwable 
	{
		connect.close();
	}

}
