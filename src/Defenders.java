import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class Defenders extends Squad
{ 
	 public void UserDefenders(String username) throws Exception
	  {     
			Scanner input= new Scanner(System.in);
	       	String player ;
	    	Path path = FileSystems.getDefault().getPath("Defenders.txt");
			File defender = new File(path.toString());
	       	while(Squad.defenders.size()<5)
	       {
	       		player = input.next();
	       		String newname = check(player,defender);
	       		checkPlayers(newname,defender,username);
	       		if(Squad.PlayerNum<3)
	       		{
	       			checkUserBudget(newname,defender,username);
		       		Squad.defenders.add(newname);
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
		System.out.println("Add defenders:");
		myfile.ReadToDefenders();
        UserDefenders(username);
	}
}
