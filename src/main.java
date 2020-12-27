import java.io.IOException;
import java.util.Scanner;
public class main 
{
	static Users users = new Users();
	static Player player = new Player();
    static Squad defender =new Defenders();
	static Squad forward = new Forwards();
	static Squad goalkeepers = new Goalkeeprs();
	static Squad midfielder = new Midfielder();
	static UserInfo info = new UserInfo();
	public static void main(String[] args) throws Exception 
	{
		Scanner input= new Scanner(System.in);
		while(true)
		{
			System.out.println("To sign up as new user press 1");
			System.out.println("To login in as existing user press 2");
			System.out.println("To Add new player press 3");
			System.out.println("To Add new Squad press 4");
			System.out.println("To exit press 5");
			
			int choice = input.nextInt(); 
			if(choice==1)  
			{
				System.out.println("Registration Page");
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
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password = input.next();
				users.login(username,password);
			}
			else if(choice==3)
			{
				System.out.println("enter the name of player : ");
				String playerName = input.next();
				System.out.println("enter the club of player : ");
				String club = input.next();
				System.out.println("enter the nationality of player : ");
				String nationality = input.next();
				System.out.println("which position would you want to add her?");
		        System.out.println("goalkeepers ,\r\n" + 
		        		"defenders \n" + 
		        		"midfielders \n" + 
		        		"forwards");
				System.out.println("enter the position of player : ");
				String position =input.next() ;
				System.out.println("enter the point of player : ");
				int point =input.nextInt();
				System.out.println("enter the budget of player : ");
				String budget =input.next();
				PlayerInfo playerinfo =new PlayerInfo(playerName,club,nationality,position,point,budget);
				player.AddPlayer(playerinfo);
			}
			else if(choice==4)
			 { 
				System.out.println("Login Page");
		    	System.out.println("Please enter username: ");
	    		String username = input.next();
	    		System.out.println("Please enter password: ");
	            String password = input.next();
				if((users.login(username,password)))
				{ 
					midfielder.add(username);
					goalkeepers.add(username);
					defender.add(username);
				    forward.add(username);    
				    System.out.println("Done :D");
				}
				else System.out.println("Failed");
			  }
			else
				break;
		}
	}

}
