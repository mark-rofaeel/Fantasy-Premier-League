import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	public static int PlayerNum = 0;
	Data data = new Data();
	public Squad() {}
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
	public String check(String name, String x) throws IOException
	{
		File filee = new File(x);
		Scanner input= new Scanner(System.in);
		FileReader out = new FileReader(filee);
	    BufferedReader br = new BufferedReader(out);
        boolean isLoginSuccess = false;
        String line, player;
        while ((line = br.readLine()) != null)
        {
        	player = line.split(" ")[0];
        	if (player.equals(name)) 
            { 
        		isLoginSuccess = true;
                break;
            }
        }
        if(!isLoginSuccess)
        {
      	  	System.out.println("The player's name does not exist, please enter again");
	        name = input.next(); 
	        check(name,x);
        }
        return name;
	}
	public void checkUserBudget(String name, String x, String username) throws IOException
	{   
		File filee = new File(x);
		File fileUser = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt");
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
		String newBudget = CalcUserBudget(user,budget);
		data.replace(user,username,newBudget);
	}
	public void checkPlayers(String name, String x ,String username) throws IOException
	{
		File filee = new File(x);
		File fileUser = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt");
		FileReader out = new FileReader(filee);
	    BufferedReader br = new BufferedReader(out);
        String line, player;
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
	}
	public String CalcUserBudget(String user_budget, String player_budget)
	{
		double userBudget = Double.parseDouble(user_budget); 
		double budget = userBudget;
		double playerBudget = Double.parseDouble(player_budget); 
		if(budget <=100.0)
		{
			budget=budget - playerBudget;	
		}
		String str = String.valueOf(budget);
		return str ;
	}
	public void checknumPlayer(String username, String club) throws IOException
	{
		PlayerNum=0;
		File f1 = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt");
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