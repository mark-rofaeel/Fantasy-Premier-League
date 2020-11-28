import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Users 
{
	Info info = new Info();
	Scanner input= new Scanner(System.in);
	File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy Premier League Project\\users.txt");
    public void register(Info info) throws IOException
  	{
    	FileWriter fr = new FileWriter(file, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
        FileReader out = new FileReader(file);
        BufferedReader br = new BufferedReader(out);
        boolean isExisting = false;
        String line, user;
        while ((line = br.readLine()) != null) 
        {
            user = line.split(" ")[0];
            if (user.equals(info.getUsername())) 
            {
                isExisting = true;
                System.out.println("Error, please enter another username, username already taken! ");
                String username = input.next();                
                break;
            }
        }
        if(isExisting)
        {
	        myWriter.write(info.getUsername());
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
}
    public void login(String username, String password) throws IOException
    {
    	FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line, user, pass;
        boolean isLoginSuccess = false;
        while ((line = br.readLine()) != null) 
        {
            user = line.split(" ")[0];
            pass = line.split(" ")[2];
            if (user.equals(username) && pass.equals(password)) 
            {
                isLoginSuccess = true;
                System.out.println("Login successfully ");                
                break;
            }
        }
        if (!isLoginSuccess)
        System.out.println("Login failed");
    }
}