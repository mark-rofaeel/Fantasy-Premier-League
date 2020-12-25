import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Defenders extends Squad
{ 
	BufferedWriter myWriter;
	FileWriter fr;
	Users user = new Users();
	Data myfile = new Data();
	Scanner input = new Scanner(System.in);
	public void UserDefenders(File file, String username) throws Exception
	{     
		String player;
	    String x ="C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Defenders.txt";
	    while(Squad.defenders.size()<5)
	    {
	    	player = input.next();
	    	String newname = check(player,x);
	        checkPlayers(newname,x,username);
	        if(Squad.PlayerNum<3)
	        {
	        	checkUserBudget(newname,x,username);
		       	myfile.userFile(newname, username, x);
		       	Squad.defenders.add(newname);
		       	Squad.squad.add(newname);
	       	}
	       	else 
	       	{
	       		System.out.println("You already have entered 3 players of the same team");	
	       	}	
	    }
	}	 
	public void add(String username) throws Exception
	{
		File fileUser = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt");
		System.out.println("Add defenders:");
		myfile.ReadToDefenders();
        UserDefenders(fileUser,username);
	}
}