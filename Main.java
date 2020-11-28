import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	Scanner input= new Scanner(System.in);
	public static void main(String[] args) throws IOException 
	{
		Users user = new Users();
		while(true)
		{
			System.out.println("To sign up as new user press 1");
			System.out.println("To login in as existing user press 2");
			System.out.println("To exit press 3");
			Scanner input= new Scanner(System.in);
			int choice = input.nextInt();
			Object String;
			if(choice==1) 
			{
				System.out.println4("Registration Page");
				System.out.printf("Username: ");
				String username = input.next();
				System.out.printf("Email: ");
				String email = input.next();
				System.out.printf("Password: ");
				String password = input.next();
				System.out.printf("Favourite Team: ");
				String favouriteTeam = input.next();
				Info info=new Info(username,email,password,favouriteTeam);
				user.register(info);
			}
			else if(choice==2)
			{
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password = input.next();
				user.login(username,password);
			}
			else
				break;
		}
	}
}