import java.io.IOException;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Users user = new Users();
		while(true)
		{
			System.out.println("To login in as existing user press 1");
			System.out.println("To sign up as new user press 2");
			System.out.println("To exit press 3");
			Scanner input= new Scanner(System.in);
			int choice = input.nextInt();
			if(choice==1)
				user.register();
			else if(choice==2)
				user.login();
			else if(choice==3)
				break;
			else
				System.out.println("Wrong input");
		}
	}
}