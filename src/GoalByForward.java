import java.io.IOException;

public class GoalByForward implements Events
{

	@Override
	public void ApplyEvents(String playername, String position,String gameweek) throws IOException 
	{
		int point = 4;
		data.Update(playername, point, position, gameweek);
		
	}

}
