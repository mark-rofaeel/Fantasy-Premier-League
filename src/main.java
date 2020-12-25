import java.io.IOException;
import java.util.Scanner;

public class main 
{
	static Users users = new Users();
	static AddPlayer player = new AddPlayer();
    static Squad defender =new Defenders();
	static Squad forward = new Forwards();
	static Squad goalkeepers = new Goalkeepers();
	static Squad midfielder = new Midfielder();
	static UserInfo info = new UserInfo();
	public static void main(String[] args) throws Exception 
	{
		while(true)
		{
			System.out.println("To sign up as new user press 1");
			System.out.println("To login in as an existing user press 2");
			System.out.println("To add new player press 3");
			System.out.println("To add new squad press 4");
			System.out.println("To exit press 5");
			Scanner input= new Scanner(System.in);
			int choice = input.nextInt(); 
			if(choice==1)  
			{
				System.out.println("Registration page");
				System.out.printf("Username: ");
				String username = input.next();
				System.out.printf("Email: ");
				String email = input.next();
				System.out.printf("Password: ");
				String password = input.next();
				System.out.printf("Favourite Team: ");
				String favouriteTeam = input.next();
				info=new UserInfo(username,email,password,favouriteTeam);//100.000
				users.register(info);
			}
			else if(choice==2)
			{
				System.out.println("Login page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password = input.next();
				users.login(username,password);
			}
			else if(choice==3)
			{
				System.out.println("Please enter the player's name: ");
				String playerName = input.next();
				System.out.println("Please enter the player's club: ");
				String club = input.next();
				System.out.println("Please enter the player's nationality: ");
				String nationality = input.next();
				System.out.println("What is the player's position?");
		        System.out.println("goalkeepers \r\n" + "defenders \n" + "midfielders \n" + "forwards");
				System.out.println("Please enter the player's position : ");
				String position =input.next() ;
				System.out.println("Please enter the player's points: ");
				int point =input.nextInt();
				System.out.println("Please enter the player's budget: ");
				String budget =input.next();
				PlayerInfo playerinfo =new PlayerInfo(playerName,club,nationality,position,point,budget);
				player.addPlayer(playerinfo);
			}
			else if(choice==4)
			{ 
				System.out.println("Login page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password = input.next();
				if((users.login(username,password)))
				{ 
					defender.add(username);
				    forward.add(username);
				    goalkeepers.add(username);
				    midfielder.add(username);
				}
				else System.out.println("Failed");
			}
			else if(choice==5)
				break;
			else
				System.out.println("Wrong input, try again");
		}
	}
}