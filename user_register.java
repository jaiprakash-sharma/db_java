import java.sql.*;
import java.util.*;
class user_register
{
	public void user_reg()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//driver loading
			String url="jdbc:mysql://localhost:3306/jai";
			Connection con=DriverManager.getConnection(url,"root","jai@mysql");//making connection b/w mysql,jre
			Statement st=con.createStatement();//statement ready
			Scanner in=new Scanner(System.in);
			System.out.println("\n\n\t\t\t\t\tPlease Enter Your Details.....");
			System.out.print("\n\t\t\t\t\tEnter your name:\n\t\t\t\t\t");
			String name=in.nextLine();
			System.out.print("\n\t\t\t\t\tEnter your Password:\n\t\t\t\t\t");
			String password=in.nextLine();
			System.out.print("\n\t\t\t\t\tRe-Enter your Password:\n\t\t\t\t\t");
			String password1=in.nextLine();
			System.out.print("\n\t\t\t\t\tEnter your address:\n\t\t\t\t\t");
			String address=in.nextLine();
			System.out.print("\n\t\t\t\t\tEnter your mobile number:\n\t\t\t\t\t");//error if taken after password
			long mob_no=in.nextLong();
			if(password.equals(password1))
			{
				String q1="INSERT INTO `jai`.`user` (`Id`, `Name`, `Password`, `Mobile Number`, `Address`) VALUES (NULL, '"+name+"', '"+password+"', '"+mob_no+"', '"+address+"')";//('"+no+"')
				int a=st.executeUpdate(q1);
				if(a>0)
				{
					System.out.println("\n\t\t\t\t\tSuccessfully registered.");
				}
				else
					System.out.println("\n\t\t\t\t\t!!!!Not registered.");
			}
			else
				System.out.println("\n\t\t\t\t\t!!!!Error in data.\n\t\t\t\t\tPlease try again...");
		}
		catch(Exception e)
		{
			
		}
	}
}