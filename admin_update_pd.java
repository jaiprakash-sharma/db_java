import java.sql.*;
import java.util.*;
public class admin_update_pd
{
	public void admin_up_pd()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","");//making connection b/w mysql,jre
			Statement st=con.createStatement();//statement ready
			Scanner in=new Scanner(System.in);
			String choice_att=null;
			System.out.println("Do you want to update your name,press yes");
			choice_att=in.nextLine();
			if(choice_att.equalsIgnoreCase("yes"))
			{
				PreparedStatement st1=con.prepareStatement("update `jai`.`admin` set `name`=?");
				System.out.println("Enter your new name:");
				String name=in.nextLine();
				st1.setString(1,name);
				int a=st1.executeUpdate();
				if(a>0)
				{	
					System.out.println("Name is updates successfully");
				}
			}
			System.out.println("Do you want to update your password,press yes");
			choice_att=in.nextLine();
			if(choice_att.equalsIgnoreCase("yes"))
			{
				PreparedStatement st1=con.prepareStatement("update `jai`.`admin` set `password`=?");
				System.out.println("Enter your new password:");
				String password=in.nextLine();
				st1.setString(1,password);
				int a=st1.executeUpdate();
				if(a>0)
				{	
					System.out.println("Password is updated successfully");
				}
			}
			System.out.println("Do you want to update your address,press yes");
			choice_att=in.nextLine();
			if(choice_att.equalsIgnoreCase("yes"))
			{
				PreparedStatement st1=con.prepareStatement("update `jai`.`admin` set `address`=?");
				System.out.println("Enter your new address:");
				String address=in.nextLine();
				st1.setString(1,address);
				int a=st1.executeUpdate();
				if(a>0)
				{	
					System.out.println("Address is updated successfully");
				}
			}
			System.out.println("Do you want to update your mobile number,press yes");
			choice_att=in.nextLine();
			if(choice_att.equalsIgnoreCase("yes"))
			{
				PreparedStatement st1=con.prepareStatement("update `jai`.`admin` set `mobile number`=?");
				System.out.println("Enter your new mobile number:");
				long mob_no=in.nextLong();
				st1.setLong(1,mob_no);
				int a=st1.executeUpdate();
				if(a>0)
				{	
					System.out.println("Mobile number is updated successfully");
				}
			}
			admin_view_pd ob=new admin_view_pd();
			ob.admin_view_pd(name,password);
		}
		catch(Exception e)
		{

		}
	}
}1032768014