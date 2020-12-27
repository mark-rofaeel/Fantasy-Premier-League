import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class Squad implements check
{
	public static ArrayList<String> defenders = new ArrayList<String>();
	public static ArrayList<String> goalkeepers = new ArrayList<String>();
	public static ArrayList<String> forwards = new ArrayList<String>();
	public static ArrayList<String> midfielders = new ArrayList<String>();
	public static ArrayList<String> squad = new ArrayList<String>();
	public void add(String info) throws IOException, Exception {}
	public static int PlayerNum = 0 ;
	Data data = new Data();
	public Squad() 
	{
		// TODO Auto-generated constructor stub
	}
	public static void setDefenders(ArrayList<String> defenders) 
	{
		Squad.defenders = defenders;
	}
	public static void setForwards(ArrayList<String> forwards) 
	{
		Squad.forwards = forwards;
	}
	public static void setGoalkeepers(ArrayList<String> goalkeepers) 
	{
		Squad.goalkeepers = goalkeepers;
	}
	public static void setMidfielders(ArrayList<String> midfielders) 
	{
		Squad.midfielders = midfielders;
	}
	public static void setSquad(ArrayList<String> squad) 
	{
		Squad.squad = squad;
	}
	public static ArrayList<String> getDefenders() 
	{
		return defenders;
	}
	public static ArrayList<String> getForwards() 
	{
		return forwards;
	}
	public static ArrayList<String> getGoalkeepers() 
	{
		return goalkeepers;
	}
	public static ArrayList<String> getMidfielders() 
	{
		return midfielders;
	}
	public static ArrayList<String> getSquad() 
	{
		return squad;
	}
	public String check(String name,File file) throws IOException
	{
		Scanner input= new Scanner(System.in);
		FileReader out = new FileReader(file);
	    BufferedReader br = new BufferedReader(out);
        boolean isLoginSuccess = false;
        String line , player;
        while ((line = br.readLine()) != null)
       {
            	   player = line.split(" ")[0];
            	   if (player.equals(name)) 
                   { 
                       isLoginSuccess = true;
                       break ;
                   }
       }
        if(!isLoginSuccess)
        {
      	   System.out.println("the name of player not exists , enter again");
	            name = input.next(); 
	            check(name,file);
        }
       return name;
	}
	public void checkUserBudget(String name,File filee ,String username) throws Exception
	{   
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File fileUser = new File(path.toString());
		FileReader out = new FileReader(filee);
	    BufferedReader br = new BufferedReader(out);
        String line , player,budget;
        while ((line = br.readLine()) != null)
	       {
	            	   player = line.split(" ")[0];
	            	   if (player.equals(name)) 
	                   { 
	                       break ;
	                   }
	       }  
        budget=line.split(" ")[4];
	       FileReader read = new FileReader(fileUser);
		   BufferedReader buffer = new BufferedReader(read);
		  String userline = buffer.readLine();
		  String user = userline.split(" ")[0];  
		  String newBudget = null;
		  newBudget=CalcUserBudget(user,budget);
		  if(newBudget=="error the budget not enough \n")
		  {
			 System.out.println("Can't add to Squad");
		  }
		  else
		  {
			  data.replace(user,username,newBudget);
			  data.userFile(name, username, filee);
		  }
		  
	}
	public void checkPlayers(String name,File x ,String username) throws IOException
	{
		FileReader out = new FileReader(x);
	    BufferedReader br = new BufferedReader(out);
        String line , player;
        while ((line = br.readLine()) != null)
       {
            	   player = line.split(" ")[0];
            	   if (player.equals(name)) 
                   { 
                       break ;
                   }
       } 
            String Club =line.split(" ")[1]; 
           checknumPlayer(username,Club);
        br.close();
	}
	public String CalcUserBudget(String user_budget , String player_budget)
	{
		double userBudget = Double.parseDouble(user_budget); 
		double budget = userBudget ;
		double playerBudget = Double.parseDouble(player_budget); 
		if(budget>=playerBudget)
		{ 
			budget=budget - playerBudget;
			String str = String.valueOf(budget);
			return str ;
		}
		else 
		{
			return "error the budget not enough \n";
		}
	}
	
	public void checknumPlayer(String username,String club) throws IOException
	{
		PlayerNum=0;
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File f1 = new File(path.toString());
		FileReader fr = new FileReader(f1);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(club))
	    	{
	    		PlayerNum++;
	    	}
	    }
	    br.close();
	}
 }