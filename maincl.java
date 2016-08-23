import java.util.*;
import java.sql.*;
public class maincl
{
	public void mainfn()
	{
		Scanner in = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("\n\t\t\t\t*****************************MENU*****************************");
			System.out.println("\t\t\t\t\t1-Register a new user.");
			System.out.println("\t\t\t\t\t2-Login for users.");
			System.out.println("\t\t\t\t\t3-login for admin.");
			System.out.print("\t\t\t\t\t4-Exit.\n\t\t\t\t\t");
			choice=in.nextInt();
			if(choice == 1)
			{
				user_register ob=new user_register();
				ob.user_reg();
			}
			else if(choice == 2)
			{
				user_login ob2=new user_login();
				ob2.user_log();
			}
			else if(choice == 3)
			{
				admin_login ob3=new admin_login();
				ob3.admin_log();
			}
		}
		while(choice!=4);
	}
	public static void main(String args[])
	{
		maincl ob=new maincl();
		ob.mainfn();
	}
}