import java.io.IOException;

public class Info 
{
		public String username;
	    public String email; 
	    public String password; 
	    public String favouriteTeam;
	    public Info()
	    { 
	    	this.username="";
	        this.email="";
	        this.favouriteTeam="";
	        this.password="";
	    }
	    public Info(String username,String email,String password,String favouriteTeam)
	    { 
	    	this.username=username;
	        this.email=email;
	        this.favouriteTeam=favouriteTeam;
	        this.password=password;
	    }
	    public void setUserName(String username) 
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
}
