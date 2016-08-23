import mypack.connect;
import java.sql.*;
public class sqltest
{
	public static void main(String args[])	
	{
		try
		{
		connect ob=new connect();
		ob.cone();
		String q="SELECT * from `user`";
		String name="jaipee";
		System.out.println("welcome to sqltest.");
		ResultSet rs=ob.st.executeQuery(q);
		System.out.println("loop");
		while(rs.next())
		{
			System.out.println("loop");
			name=rs.getString(2);
			int id=rs.getInt("id");
			System.out.println(name);
			System.out.println(id);
		}
		System.out.println("Byee");
		}
		catch(Exception e)
		{

		}
	}
}