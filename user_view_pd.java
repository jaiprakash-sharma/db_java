import java.sql.*;
import java.util.*;
public class user_view_pd
{
	public void user_view_p(String x,String y)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","jai@mysql");//making connection b/w mysql,jre
			Statement st=con.createStatement();//statement ready
			Scanner in=new Scanner(System.in);
			String name=x;
			String name_loop=x;
			String password=y;
			String password_loop=y;
			String password_old=y;
			ResultSet rs=st.executeQuery("select * from `jai`.`user` where `name`='"+name+"' and `password`='"+password+"'");
			System.out.println("\n\n\t\t\t\t\tYour personel details are:");
			while(rs.next())
			{
				int id=rs.getInt(1);
				name=rs.getString(2);
				password=rs.getString(3);
				long mob_no=rs.getLong(4);
				String address=rs.getString(5);
				System.out.print("\n\n\t\t\t\t\tYour Unique Id is:                "+id);
				System.out.print("\n\t\t\t\t\tYour registered Name  is:         "+name);
				System.out.print("\n\t\t\t\t\tYour registered Mobile Number is: "+mob_no);
				System.out.print("\n\t\t\t\t\tYour registered address is:       "+address);
				System.out.print("\n\t\t\t\t\tDo you want to update your personnel details,press yes\n\t\t\t\t\t");
				String ch=in.nextLine();
				if(ch.equalsIgnoreCase("yes"))
				{
					String choice_att=null;
					System.out.print("\n\t\t\t\t\tDo you want to update your name,press yes\n\t\t\t\t\t");
					choice_att=in.nextLine();
					if(choice_att.equalsIgnoreCase("yes"))
					{
						PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `name`=? where `name`='"+name+"'");
						System.out.print("\t\t\t\t\tEnter your new name:\n\t\t\t\t\t");
						name=in.nextLine();
						st1.setString(1,name);
						int a=st1.executeUpdate();
						if(a>0)
						{	
							System.out.println("\t\t\t\t\tName is updates successfully");
							name_loop=name;
						}
						else
							System.out.println("\t\t\t\t\t!!!!Name is not updated.");
					}
					System.out.print("\n\t\t\t\t\tDo you want to update your password,press yes\n\t\t\t\t\t");
					choice_att=in.nextLine();
					if(choice_att.equalsIgnoreCase("yes"))
					{
						PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `password`=? where `name`='"+name+"'");
						System.out.print("\n\t\t\t\t\tFirst enter your old password:\n\t\t\t\t\t");
						String password_old1=in.nextLine();
						if(password_old.equals(password_old1))
						{
							System.out.print("\n\t\t\t\t\tEnter your new password:\n\t\t\t\t\t");
							password=in.nextLine();
							System.out.print("\n\t\t\t\t\tRe-Enter your Password:\n\t\t\t\t\t");
							String password1=in.nextLine();
							if(password.equals(password1))
							{
								st1.setString(1,password);
								int a=st1.executeUpdate();
								if(a>0)
								{	
									System.out.println("\t\t\t\t\tPassword is updated successfully");
									password_loop=password;
								}
								else
									System.out.println("\t\t\t\t\t!!!!Password is not updated.");
							}
							else
								System.out.println("\t\t\t\t\t!!!!Passwords do not match.");
						}
						else
							System.out.println("\t\t\t\t\t!!!!Your old password is incorrect.");
					}
					System.out.print("\n\t\t\t\t\tDo you want to update your address,press yes\n\t\t\t\t\t");
					choice_att=in.nextLine();
					if(choice_att.equalsIgnoreCase("yes"))
					{
						PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `address`=? where `name`='"+name+"'");
						System.out.print("\n\t\t\t\t\tEnter your new address:\n\t\t\t\t\t");
						address=in.nextLine();
						st1.setString(1,address);
						int a=st1.executeUpdate();
						if(a>0)
						{	
							System.out.println("\t\t\t\t\tAddress is updated successfully");
						}
						else
							System.out.println("\t\t\t\t\t!!!!Address is not updated.");
					}
					System.out.print("\n\t\t\t\t\tDo you want to update your mobile number,press yes\n\t\t\t\t\t");
					choice_att=in.nextLine();
					if(choice_att.equalsIgnoreCase("yes"))
					{
						PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `mobile number`=? where `name`='"+name+"'");
						System.out.print("\n\t\t\t\t\tEnter your new mobile number:\n\t\t\t\t\t");
						mob_no=in.nextLong();
						st1.setLong(1,mob_no);
						int a=st1.executeUpdate();
						if(a>0)
						{	
							System.out.println("\t\t\t\t\tMobile number is updated successfully");
						}
						else
							System.out.println("\t\t\t\t\tMobile Number is not updated.");
					}
					System.out.print("\n\t\t\t\t\tDo you want to update your Secret question,answer,press yes\n\t\t\t\t\t");
						choice_att=in.nextLine();
						if(choice_att.equalsIgnoreCase("yes"))
						{
							PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `question`=?,`answer`=? where `name`='"+name+"'");
							System.out.print("\n\t\t\t\t\tEnter your new question:\n\t\t\t\t\t");
							String ques=in.nextLine();
							System.out.print("\n\t\t\t\t\tEnter your answer:\n\t\t\t\t\t");
							String ans=in.nextLine();
							st1.setString(1,ques);
							st1.setString(2,ans);
							int a=st1.executeUpdate();
							if(a>0)
							{	
								System.out.println("\t\t\t\t\tDetails are updated successfully");
								password_loop=password;
							}
							else
								System.out.println("\t\t\t\t\t!!!!Details not updated.");
						}
				}

			}
			System.out.print("\n\t\t\t\t\tDo you want to logout:\n\t\t\t\t\t");
			String logout=in.nextLine();
			if(logout.equalsIgnoreCase("yes"))
			{
				System.out.println("\n\t\t\t\t\tYou have loggedout successfully.");
				maincl ob=new maincl();
				ob.mainfn();
			}
			else
			{
				user_view_pd ob=new user_view_pd();
				ob.user_view_p(name_loop,password_loop);
			}
		}
		catch(Exception e)
		{

		}
	}
}