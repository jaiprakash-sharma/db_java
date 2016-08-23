import java.sql.*;
import java.util.*;
public class user_login
{
	public void user_log()
	{
		try
		{
			System.out.println("\n\n\t\t\t\t\tPlease fill following details....");
			Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","jai@mysql");//making connection b/w mysql,jre
			Statement st=con.createStatement();//statement ready
			Scanner in=new Scanner(System.in);
			int flag=0;
			int flag2=0;
			int flag3=0;
			String sa=null;
			System.out.print("\n\t\t\t\t\tEnter your name:\n\t\t\t\t\t");
			String name=in.nextLine();
			System.out.print("\n\t\t\t\t\tEnter your Password:\n\t\t\t\t\t");
			String password=in.nextLine();
			ResultSet rs=st.executeQuery("select * from `jai`.`user` where `name`='"+name+"' and `password`='"+password+"'");
			while(rs.next())
			{
				System.out.println("\n\t\t\t\t\tYou have logged in successfully.");
				user_view_pd ob=new user_view_pd();
				ob.user_view_p(name,password);
				flag=1;
			}
			if(flag==0)
			{
				System.out.println("\n\t\t\t\t\tError in input data.\n\t\t\t\t\tTry again...");
				System.out.print("\n\t\t\t\t\tDo you want to recover your password:\n\t\t\t\t\t");
				String cho=in.nextLine();
				if(cho.equalsIgnoreCase("yes"))
				{
					flag3=1;
					System.out.print("\n\t\t\t\t\tEnter your name:\n\t\t\t\t\t");
					name=in.nextLine();
					System.out.print("\n\t\t\t\t\tEnter your registered number:\n\t\t\t\t\t");
					long number=in.nextLong();
					ResultSet rs1=st.executeQuery("select * from `jai`.`user` where `name`='"+name+"' and `mobile number`='"+number+"'");
					while(rs1.next())
					{
						String ques=rs1.getString("question");
						if(!ques.equals("NULL"))
						{
							System.out.println("\n\t\t\t\t\tYour secret question is:\n\t\t\t\t\t"+ques);	
							System.out.print("\n\t\t\t\t\tEnter your secret answer:\n\t\t\t\t\t");
							String temp=in.nextLine();
							sa=in.nextLine();
							ResultSet rs2=st.executeQuery("select * from `jai`.`user` where `name`='"+name+"' and `answer`='"+sa+"'");
							while(rs2.next())
							{
								PreparedStatement st1=con.prepareStatement("update `jai`.`user` set `password`=?");
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
										System.out.println("\n\t\t\t\t\tPassword is updated successfully");
									}
									else
										System.out.println("\n\t\t\t\t\tPasswords is not updated.");
								}
								else
									System.out.println("\n\t\t\t\t\tPasswords do not match.");
								flag2=1;
							}
						}
						else
							System.out.println("\n\t\t\t\t\t!!!! No Secret question found.");
						if((flag2==0)&&!ques.equals("NULL"))
						{
							System.out.println("\n\t\t\t\t\tWrong answer.\n\t\t\t\t\tTry Again");
						}
					}
				}
			}
		}
		catch(Exception e)
		{

		}
	}
}