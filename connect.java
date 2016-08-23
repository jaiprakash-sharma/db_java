package mypack;  
import java.sql.*;
public class connect
{  
	public Connection con;
	public Statement st;
	public void cone()
	{  
		try
		{
 	   		System.out.println("Welcome to package"); 
 	   		Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","");
			Statement st=con.createStatement();
			 
		}
		catch(Exception e)
		{

		}
    }  
}