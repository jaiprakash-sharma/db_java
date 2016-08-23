import java.sql.*;
import java.util.*;
public class admin_view_ud
{
	public void admin_view_u()
	{
		try
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Welcome to user_login");
			Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","jai@mysql");//making connection b/w mysql,jre
			Statement st=con.createStatement();//statement ready
			String logout=null;
			ResultSet rs=st.executeQuery("SELECT * from `jai`.`user`");
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String password=rs.getString(3);
				long mob_no=rs.getLong(4);
				String address=rs.getString(5);
				System.out.println("\t\t\t\t\tUnique Id is:                "+id);
				System.out.println("\t\t\t\t\tRegistered Name  is:         "+name);
				System.out.println("\t\t\t\t\tRegistered Mobile Number is: "+mob_no);
				System.out.println("\t\t\t\t\tRegistered address is:       "+address);
			}
			System.out.print("\n\t\t\t\t\tDo you want to delete any user,press yes\n\t\t\t\t\t");
			String ch=in.nextLine();
			if(ch.equalsIgnoreCase("yes"))
			{
				System.out.println("\n\t\t\t\t\tEnter the user id:");
				int id=in.nextInt();
				PreparedStatement st1=con.prepareStatement("delete from `jai`.`user` where `id`=?");
				st1.setInt(1,id);
				int a=st1.executeUpdate();
				if(a>0)
				{
					System.out.println("\n\t\t\t\t\tUser deleted successfully.");
				}
			}
			System.out.print("\n\t\t\t\t\tDo you want to go back.\n\t\t\t\t\t");
			logout=in.nextLine();
			if(logout.equalsIgnoreCase("yes"))
			{
				System.out.println("\n\t\t\t\t\tYou have backked out successfully.");
			}
			else
			{
				admin_view_ud ob=new admin_view_ud();
				ob.admin_view_u();
			}
		}
		catch(Exception e)
		{

		}
	}
}