import java.io.IOException;

public class OwnGoalEvent implements Events
{

	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = -2 ;
		data.Update(playername, point, position, gameweek);
		
	}

}