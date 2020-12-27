import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Forwards extends Squad
{
	 public void UserForwards(String username) throws Exception
	  {     
		 	Scanner input= new Scanner(System.in);
	       	String player ;
	       	Path path = FileSystems.getDefault().getPath("Forwards.txt");
			File forward = new File(path.toString());
	       	while(Squad.forwards.size()<3)
	       {
	       		player = input.next();
	       		String newname = check(player,forward);
	       		checkPlayers(newname,forward,username);
	       		if(Squad.PlayerNum<3)
	       		{
	       			checkUserBudget(newname,forward,username);
		       		Squad.forwards.add(newname);
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
		System.out.println("Add Forwards:");
		myfile.ReadToForwards();
        UserForwards(username);
	}
}
