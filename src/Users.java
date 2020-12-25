import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Users implements check
{
	UserInfo info = new UserInfo();
	Data data = new Data();
	Scanner input= new Scanner(System.in);
	File file; 
	public String check(String username, String x) throws IOException
	{
		File file = new File(x);
        FileReader out = new FileReader(file);
        BufferedReader br = new BufferedReader(out);
        String line,user;
        boolean isExsiting = true;
        while ((line = br.readLine()) != null) 
        {
        	user = line.split(" ")[0];
            if (user.equals(username)) 
            {  
            	isExsiting =false;
                System.out.println("Error, please enter another username, username already taken! ");
                username = input.next(); 
                check(username,x);
                break;
            }
        }
        if(isExsiting)
        	info.setUserName(username); 
        br.close();
        return info.username;
	}	
	public void UserFile(UserInfo info) throws IOException
	{
		file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+info.getUsername()+".txt");
		file.createNewFile();
		FileWriter fr = new FileWriter(file, true);
       	BufferedWriter myWriter=new BufferedWriter(fr);
       	myWriter.write("100.0");
       	myWriter.newLine();
       	myWriter.close();
	}
    public void register(UserInfo info) throws IOException
    {
    	String x = "C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\users.txt";
    	String z = check(info.getUsername(),x);
    	data.file(x ,info,z);
    	UserFile(info);
    }
    public boolean login(String username, String password) throws IOException
    {
    	file = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\users.txt");
    	File myfile = new File("C:\\Users\\Mark Rofaeel\\eclipse-workspace\\Fantasy project\\"+username+".txt");
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
		return isLoginSuccess;
    }
}