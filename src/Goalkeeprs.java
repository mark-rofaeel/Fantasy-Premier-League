import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Goalkeeprs extends Squad 
{
	 public void UserGoalKeeprs(String username) throws Exception
	  {     
			Scanner input= new Scanner(System.in);
	       	String player ;
	       	Path path = FileSystems.getDefault().getPath("GoalKeeprs.txt");
			File GoalKeeprs = new File(path.toString());
	       	while(Squad.goalkeepers.size()<2)
	       {
	       		player = input.next();
	       		String newname = check(player,GoalKeeprs);
	       		checkPlayers(newname,GoalKeeprs,username);
	       		if(Squad.PlayerNum<3)
	       		{
	       			checkUserBudget(newname,GoalKeeprs,username);
		       		Squad.goalkeepers.add(newname);
		       		Squad.squad.add(newname);
	       		}
	       		else 
	       		{
	       			System.out.println("Error you entered the 3 players in the same club");
	       		}
	       		
	       	}
	    
	  }	
	 
	public void add(String username) throws Exception
	{
		Data myfile =new Data() ;
		System.out.println("Add GoalKeeprs:");
		myfile.ReadToGoalKeeprs();
        UserGoalKeeprs(username);
	}
}
