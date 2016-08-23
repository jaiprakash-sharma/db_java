import java.sql.*;
import java.util.*;
public class admin_login
{
	public void admin_log()
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
			String logout;
			System.out.print("\n\t\t\t\t\tEnter your name:\n\t\t\t\t\t");
			String name=in.nextLine();
			System.out.print("\n\t\t\t\t\tEnter your Password:\n\t\t\t\t\t");
			String password=in.nextLine();
			ResultSet rs=st.executeQuery("select * from `jai`.`admin` where `name`='"+name+"' and `password`='"+password+"'");
			while(rs.next())
			{
				System.out.println("\n\t\t\t\t\tSuccessfully login.");
				flag=1;
				int ch;
				do
				{
					System.out.print("\n\t\t\t\t\tpress 1 to view your personel details.");
					System.out.print("\n\t\t\t\t\tpress 2 to view users details.");
					System.out.print("\n\t\t\t\t\tPress 3 to exit.\n\t\t\t\t\t");
					ch=in.nextInt();
					if(ch==1)
					{
						admin_view_pd ob=new admin_view_pd();
						ob.admin_view_p(name,password);
					}
					if(ch==2)
					{
						admin_view_ud ob=new admin_view_ud();
						ob.admin_view_u();
					}
				}
				while(ch!=3);		
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
					ResultSet rs1=st.executeQuery("select * from `jai`.`admin` where `name`='"+name+"' and `mobile number`='"+number+"'");
					while(rs1.next())
					{
						String ques=rs1.getString("question");
						if(!ques.equals("NULL"))
						{
							System.out.println("\n\t\t\t\t\tYour secret question is:\n\t\t\t\t\t"+ques);	
							System.out.print("\n\t\t\t\t\tEnter your secret answer:\n\t\t\t\t\t");
							String temp=in.nextLine();
							sa=in.nextLine();
							ResultSet rs2=st.executeQuery("select * from `jai`.`admin` where `name`='"+name+"' and `answer`='"+sa+"'");
							while(rs2.next())
							{
								PreparedStatement st1=con.prepareStatement("update `jai`.`admin` set `password`=?");
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