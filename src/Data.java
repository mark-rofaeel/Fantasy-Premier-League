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

public class Data 
{
	File file ;
	Path goalkeepers = FileSystems.getDefault().getPath("GoalKeeprs.txt");
	Path defenders = FileSystems.getDefault().getPath("Defenders.txt");
	Path midfielder = FileSystems.getDefault().getPath("Midfielders.txt");
	Path forward = FileSystems.getDefault().getPath("Forwards.txt");
	public void fileWriter(File file,PlayerInfo info) throws IOException
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
	public void file(File file, UserInfo info,String name) throws IOException 
	{ 
			FileWriter fr = new FileWriter(file, true);
	       	BufferedWriter myWriter=new BufferedWriter(fr);
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
	public void userFile(String playername , String username,File filename) throws IOException, Exception
	{
		Path path = FileSystems.getDefault().getPath(username+".txt");
		File userfile = new File(path.toString());
		FileReader out = new FileReader(filename);
	    BufferedReader br = new BufferedReader(out);
	    FileWriter fr = new FileWriter(userfile, true);
       	BufferedWriter pw=new BufferedWriter(fr);
        String line , player;
		if(filename.getName().equals("Defenders.txt"))
        {
        	pw.write("Defenders: ");
        }
        else if(filename.getName().equals("Forwards.txt"))
        {
        	pw.write("Forwards: ");
        }
        else if(filename.getName().equals("GoalKeeprs.txt"))
        {
        	pw.write("GoalKeeprs: ");
        }
        else if(filename.getName().equals("Midfielders.txt"))
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
	 
	public void fileReader(File file) throws IOException
	{      
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) 
            {
                System.out.println(line);
	        }
            br.close();
    }
	public void  replace(String oldBudget , String fileName,String newLine) throws IOException
    {
		ArrayList<String> lines = new ArrayList<String>();
		Path path = FileSystems.getDefault().getPath(fileName+".txt");
		file = new File(path.toString());
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
			//out.newLine();
		    out.write(lines.get(i)+'\n');
		}
		System.out.println("new budget : " + newLine);
		br.close();
		out.close();
    }
	
	public void ReadToGoalKeeprs() throws IOException 
	{
		
		file = new File(goalkeepers.toString());
		fileReader(file);
	}
	public void ReadToDefenders() throws IOException
	{  
		file = new File(defenders.toString());
		fileReader(file);
	}
	public void ReadToMidfielders() throws IOException
	{
		file = new File(midfielder.toString());
		fileReader(file);
	}
	public void ReadToForwards() throws IOException
	{
		
		file = new File(forward.toString());
		fileReader(file);
	}
	
	public void writeToGoalKeeprs(PlayerInfo p) throws IOException 
	{ 
		file = new File(goalkeepers.toString());
		fileWriter(file,p);
	}
	public void writeToDefenders(PlayerInfo p) throws IOException
	{   
		file = new File(defenders.toString());
		fileWriter(file,p);
	}
	public void writeToMidfielders(PlayerInfo p) throws IOException
	{
		file = new File(midfielder.toString());
		fileWriter(file,p);
	}
	public void writeToForwards(PlayerInfo p) throws IOException
	{
		file = new File(forward.toString());
		fileWriter(file,p);
	}
	
}
