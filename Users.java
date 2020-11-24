import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Users 
{
	Scanner input= new Scanner(System.in);
	File file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy Premier League Project\\users.txt");
    public String username;
    public String email; 
    public String password; 
    public String favouriteTeam;
    public Users() throws IOException
    { 
    	this.username="";
        this.email="";
        this.favouriteTeam="";
        this.password="";
    }
    public void setName(String username) 
    {
		this.username = username;
    }
    public String getUsername() 
    {
		return username;
	}
    public void setEmail(String email) 
    {
		this.email = email;
	}
    public String getEmail() 
    {
		return email;
	}
    public void setPassword(String password) 
    {
		this.password = password;
	}
    public String getPassword() 
    {
    	return password;
	}
    public void setfavouriteTeam(String favouriteTeam) 
    {
    	this.favouriteTeam=favouriteTeam;
    }
    public String getfavouriteTeam() 
    {
        return favouriteTeam;
    }
    public void register() throws IOException
  	{
    	FileWriter fr = new FileWriter(file, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
		System.out.println("Registration Page");
        System.out.printf("Username: ");
        String username = input.next();
        FileReader out = new FileReader(file);
        BufferedReader br = new BufferedReader(out);
        boolean isExisting = false;
        String line, user;
        while ((line = br.readLine()) != null) 
        {
            user = line.split(" ")[0];
            if (user.equals(username)) 
            {
                isExisting = true;
                System.out.println("Error, please enter another username, username already taken! ");
                username = input.next();
                break;
            }
        }
        if(isExisting)
        {
	        System.out.printf("Email: ");
	        String email = input.next();
	        System.out.printf("Password: ");
	        String password = input.next();
	        System.out.printf("Favourite Team: ");
	        String favouriteTeam = input.next();
	        myWriter.write(username);
	        myWriter.write(" ");
	        myWriter.write(email);
	        myWriter.write(" ");
	        myWriter.write(password);
	        myWriter.write(" ");
	        myWriter.write(favouriteTeam);
	        myWriter.newLine();
	        myWriter.close();
	        fr.close();
  	}
}
    public void login() throws IOException
    {
    	System.out.println("Please enter username: ");
    	String username = input.next();
    	System.out.println("Please enter password: ");
        String password = input.next();
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