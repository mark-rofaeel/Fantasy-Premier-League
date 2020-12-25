import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Data 
{
	File file;
	public void fileWriter(File file, PlayerInfo info) throws IOException
	{  
		FileWriter fr = new FileWriter(file, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
       	myWriter.newLine();
       	myWriter.write(info.getPlayername() + " ");
       	myWriter.write(info.getClub()+ " ");
       	myWriter.write(info.getNationality()+" ");
       	myWriter.write(info.getPoint()+ " ");
       	myWriter.write(info.getBudget());
       	myWriter.close();
        fr.close();
	}
	public void file(String x, UserInfo info, String name) throws IOException 
	{ 
		File file = new File(x);
		FileWriter fr = new FileWriter(file, true);
	    BufferedWriter myWriter = new BufferedWriter(fr);
	    myWriter.write(name);
	    myWriter.write(" ");
	    myWriter.write(info.getEmail());
	    myWriter.write(" ");
	    myWriter.write(info.getPassword());
	    myWriter.write(" ");
	    myWriter.write(info.getfavouriteTeam());
	    myWriter.newLine();
	    myWriter.close();
	    fr.close();
    }
	public void userFile(String playername, String username, String filename) throws IOException
	{		
		File file = new File(filename);
		FileReader out = new FileReader(file);
	    BufferedReader br = new BufferedReader(out);
	    String fileuser = "C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt";
	    FileWriter fr = new FileWriter(fileuser, true);
       	BufferedWriter pw=new BufferedWriter(fr);
        String line, player;
        if(filename.equals("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Defenders.txt"))
        {
        	pw.write("Defenders: ");
        }
        else if(filename.equals("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Forwards.txt"))
        {
        	pw.write("Forwards: ");
        }
        else if(filename.equals("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Goalkeepers.txt"))
        {
        	pw.write("Goalkeepers: ");
        }
        else if(filename.equals("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Midfielders.txt"))
        {
        	pw.write("Midfielders: ");
        }
        while ((line = br.readLine()) != null)
        {
        	player = line.split(" ")[0];
        	if (player.equals(playername)) 
            {   
        		pw.write(line);
                break ;
            }
        }
        pw.close();
        br.close();
	} 
	public void fileReader(String x) throws IOException
	{        
		file = new File(x);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) 
        {
        	System.out.println(line);
	    }
    }
	public void replace(String oldBudget, String fileName, String newLine) throws IOException
    {
		ArrayList<String> lines = new ArrayList<String>();
		File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+fileName+".txt");
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    String line;
	    lines.clear();
	    while((line = br.readLine())!= null)
	    {
	    	if (line.contains(oldBudget))
	    	{
	    		line = line.replace(line, newLine);
	    	}
	        lines.add(line);
	    }
	    PrintWriter writer = new PrintWriter(file);
	    writer.print(lines.get(0));
	    writer.close();
		BufferedWriter out=new BufferedWriter(new FileWriter(file,true));
		out.newLine();
		for(int i=1;i<lines.size();i++)
		{
		    out.write(lines.get(i)+'\n');
		}
		br.close();
		out.close();
    }
	public void ReadToGoalKeeprs() throws IOException 
	{
		String z ="C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Goalkeepers.txt";
		fileReader(z);
	}
	public void ReadToDefenders() throws IOException
	{  
		String z ="C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Defenders.txt";
		fileReader(z);
	}
	public void ReadToMidfielders() throws IOException
	{
		String x ="C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Midfielders.txt";
		fileReader(x);
	}
	public void ReadToForwards() throws IOException
	{
	    String x ="C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Forwards.txt";
		fileReader(x);
	}
	public void writeToGoalKeeprs(PlayerInfo p) throws IOException 
	{
		file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Goalkeepers.txt");
		fileWriter(file,p);
	}
	public void writeToDefenders(PlayerInfo p) throws IOException
	{  
		File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Defenders.txt");
		fileWriter(file,p);
	}
	public void writeToMidfielders(PlayerInfo p) throws IOException
	{
		File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Midfielders.txt");
		fileWriter(file,p);
	}
	public void writeToForwards(PlayerInfo p) throws IOException
	{
		File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\Forwards.txt");
		fileWriter(file,p);
	}	
}